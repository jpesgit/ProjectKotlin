package com.example.joaopedrosilva.projectkotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    private var listFragment: ListFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        buttonAddFrag.setOnClickListener {
            listFragment = ListFragment.newInstance()
            supportFragmentManager.beginTransaction().replace(R.id.contentFragment, listFragment).commit()

        }
    }
}
