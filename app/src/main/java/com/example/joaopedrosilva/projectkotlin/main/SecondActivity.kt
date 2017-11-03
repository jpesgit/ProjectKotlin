package com.example.joaopedrosilva.projectkotlin.main

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.example.joaopedrosilva.projectkotlin.R
import com.example.joaopedrosilva.projectkotlin.main.WikiSearch.WikiFragment
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity(), View.OnClickListener {

    // no que diz respeito a fragmentos, não cries referências
    // só em casos concretos (criar referencia é sempre má ideais)
    // para além disso não precisas dela neste cenário
//    private var exampleFragment: ExampleFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        buttonAddFrag.setOnClickListener(this)
        buttonNews.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.buttonAddFrag -> {
                val exampleFragment = ExampleFragment.newInstance()
                supportFragmentManager.beginTransaction().replace(R.id.contentFragment, exampleFragment).commit()
            }
            R.id.buttonNews -> {
                val wikiFragment = WikiFragment.newInstance()
                supportFragmentManager.beginTransaction().replace(R.id.contentFragment, wikiFragment).commit()
            }
        }
    }


}
