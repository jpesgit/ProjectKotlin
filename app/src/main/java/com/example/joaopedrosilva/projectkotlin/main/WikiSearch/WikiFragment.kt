package com.example.joaopedrosilva.projectkotlin.main.WikiSearch

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.joaopedrosilva.projectkotlin.R
import com.jakewharton.rxbinding2.widget.RxTextView
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_wiki.*
import java.util.concurrent.TimeUnit.MILLISECONDS

/**
 * Created by joaopedrosilva on 03/11/17.
 */
class WikiFragment : Fragment() {

    var TAG = WikiFragment::class.java.canonicalName
    var disposable: Disposable? = null

    val wikiAdapter = WikiAdapter()

    val wikiApiServe by lazy {

        // Isto tem de vir do dagger com appscope. Vê na app prozisGo como está feito (branch production)
        // só fazes este call uma vez na app inteira
        WikiApiService.create()
    }

    companion object {
        fun newInstance(): WikiFragment {
            return WikiFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_wiki, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        wikis_rv.run {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = wikiAdapter
        }

        RxTextView.textChangeEvents(edit_search)
                .skipInitialValue()
                .debounce(500, MILLISECONDS) // vê a doc para aqui
                .map { it.text().toString() }
                .subscribeOn(Schedulers.io())
                .flatMap {
                    if (it.isNotEmpty()) {
                        wikiApiServe.hitCountCheck("query", "json", "search", it)
                                .map<Results> { Results.Result(it) }
                    } else {
                        Observable.just(Results.ResultEmpty)
                    }
                }
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { result ->
                            when (result) {
                                is WikiFragment.Results.Result -> formatResult(result.items)
                                is WikiFragment.Results.ResultEmpty -> clearData()
                            }
                        },
                        { error ->
                            Log.i(TAG, "", error)
                            Toast.makeText(context, error.message, Toast.LENGTH_SHORT).show()
                        }
                )
    }

    sealed class Results {
        object ResultEmpty : Results()
        class Result(val items: ResultWiki) : Results()
    }

    private fun clearData() {
        wikiAdapter.setAdapterItems(emptyList())
        txt_search_result.text = ""
    }

    private fun formatResult(resultWiki: ResultWiki) {
        val qtt = resultWiki.query.searchInfo.totalHits
        txt_search_result.text = getString(R.string.wiki_search_results_found, qtt)
        wikiAdapter.setAdapterItems(resultWiki.query.search)
    }
}
