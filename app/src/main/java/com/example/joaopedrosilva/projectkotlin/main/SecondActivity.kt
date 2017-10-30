package com.example.joaopedrosilva.projectkotlin.main

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.example.joaopedrosilva.projectkotlin.R
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity(), View.OnClickListener {

    private var exampleFragment: ExampleFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        buttonAddFrag.setOnClickListener(this)
        buttonList.setOnClickListener(this)

    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.buttonAddFrag -> {
                exampleFragment = ExampleFragment.newInstance()
                supportFragmentManager.beginTransaction().replace(R.id.contentFragment, exampleFragment).commit()
            }
        }
    }

}
