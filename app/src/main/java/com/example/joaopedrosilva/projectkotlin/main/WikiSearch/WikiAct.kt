package com.example.joaopedrosilva.projectkotlin.main.WikiSearch

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.example.joaopedrosilva.projectkotlin.R
import com.example.joaopedrosilva.projectkotlin.communication.WikiApiProvider
import com.example.joaopedrosilva.projectkotlin.communication.WikiRestAPI
import com.example.joaopedrosilva.projectkotlin.main.ExampleFunctionsFragment
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_second.*
import javax.inject.Inject

class WikiAct : AppCompatActivity(), View.OnClickListener, WikiApiProvider {

    @Inject lateinit var wikiRestApi: WikiRestAPI

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        AndroidInjection.inject(this)
        buttonAddFrag.setOnClickListener(this)
        buttonWiki.setOnClickListener(this)
    }

    override fun provideWikiRestApi(): WikiRestAPI
            = wikiRestApi

    override fun onClick(view: View) {
        when (view.id) {
            R.id.buttonAddFrag -> {
                val exampleFunctionsFragment = ExampleFunctionsFragment.newInstance()
                supportFragmentManager.beginTransaction().replace(R.id.contentFragment, exampleFunctionsFragment).commit()
            }
            R.id.buttonWiki -> {
                val wikiFragment = WikiFragment.newInstance()
                supportFragmentManager.beginTransaction().replace(R.id.contentFragment, wikiFragment).commit()
            }
        }
    }


}
