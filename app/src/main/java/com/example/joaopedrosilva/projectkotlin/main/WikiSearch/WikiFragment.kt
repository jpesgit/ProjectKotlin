package com.example.joaopedrosilva.projectkotlin.main.WikiSearch

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.joaopedrosilva.projectkotlin.R
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_wiki.*

/**
 * Created by joaopedrosilva on 03/11/17.
 */
class WikiFragment : Fragment(), View.OnClickListener {

    var TAG = WikiFragment::class.java.canonicalName
    var disposable: Disposable? = null

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
//    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
//        val view = inflater.inflate(R.layout.fragment_wiki, container, false)

        return inflater.inflate(R.layout.fragment_wiki, container, false)
//        return view
    }

    override fun onResume() {
        super.onResume()
        btn_search.setOnClickListener(this)

    }

    override fun onClick(view: View) {
//    override fun onClick(v: View) {
//        when (v.id) {
        when (view.id) {
            R.id.btn_search -> if (edit_search.text.toString().isNotEmpty()) {
                beginSearch(edit_search.text.toString())
            }
        }
    }

    private fun beginSearch(searchString: String) {
        disposable = wikiApiServe.hitCountCheck("query", "json", "search", searchString)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { result -> txt_search_result.text = "${result.query.searchinfo.totalhits} result found" },
                        { error -> Toast.makeText(context, error.message, Toast.LENGTH_SHORT).show() }
                )
    }
}