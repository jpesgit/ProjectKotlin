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
import com.example.joaopedrosilva.projectkotlin.communication.WikiApiProvider
import com.example.joaopedrosilva.projectkotlin.communication.WikiRestAPI
import com.jakewharton.rxbinding2.widget.RxTextView
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_wiki.*
import java.util.concurrent.TimeUnit.MILLISECONDS

class WikiFragment : Fragment() {

    /**
     * Acerca do relative_layout_background.xml
     * -- não é um selector, devia ser um layer-list (o selected implica teres mais de um estado)
     * -- não precisas da parte que preenche cor a cor branca (é desnecessário e implicada mais draws que não são precisos)
     *
     * Acerca do itemWiki.zml
     * -- não precisas do linearLayout, podes fazer tudo com um relativeLayout
     * -- mostra algum texto no layout para melhor visualização. Usa tools:text. assim é só um atribute de design-time (nao aparece no device)
     * -- não deves usar margens para os items de uma recyclerview. Se quiseres espaços entre multiplos items, cria um ItemDecorator e usa como (rv.addItemDecoration(customItemDecorator))
     */

    var TAG = WikiFragment::class.java.canonicalName
    var disposable: Disposable? = null

    val wikiAdapter = WikiAdapter()

    private val mWikiRestApi: WikiRestAPI
        get() = (activity as WikiApiProvider)
                .provideWikiRestApi()

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

        // não é garantido que a activity não seja null aqui. o Melhor é usares um interface

        wikis_rv.run {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = wikiAdapter
        }

        disposable = RxTextView.textChangeEvents(edit_search)
                .skipInitialValue()
                // debounce n era o operador certo (debounce basicamente atarda cada evento pelo tempo especificado)
                // faz mais sentido throttleLast, que basicamente só propaga o último evento em cada 500ms
                // ou seja, se escreveres mt rapido, não vale a pena estares a fazer uma chamada para cada mudança de letra
                // assim, só de 500 em 500 ms é que faz uma chamada
                .throttleLast(500, MILLISECONDS)
                .map { it.text().toString() }
                .subscribeOn(Schedulers.io())
                .flatMap {
                    if (it.isNotEmpty()) {
                        mWikiRestApi.hitCountCheck("query", "json", "search", it)
                                .map<Results> { Results.Result(it) }
                    } else {
                        Observable.just(Results.ResultEmpty)
                    }
                }
                .onErrorReturn { Results.ResultEmpty } // se acontecer um error de network no stream, o observable nunca mais funciona se nao tiver este método
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

    override fun onDestroyView() {
        super.onDestroyView()
        disposable?.dispose()
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
