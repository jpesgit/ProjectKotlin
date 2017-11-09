package com.example.joaopedrosilva.projectkotlin.main

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.example.joaopedrosilva.projectkotlin.R
import com.example.joaopedrosilva.projectkotlin.main.ToDo.ToDoActivity
import com.example.joaopedrosilva.projectkotlin.main.WikiSearch.WikiAct
import com.example.joaopedrosilva.projectkotlin.utils.startActivity
import com.example.joaopedrosilva.projectkotlin.utils.toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        welcomeMessage.text = getString(R.string.app_name)
        buttonLogin.setOnClickListener(this)
        buttonFunctions.setOnClickListener(this)
    }

    private fun login(user: String, pass: String) {
        if (user == "a" && pass == "a") {
            toast("success")
            startActivity<ToDoActivity>()
        } else {
            toast("try again")
        }
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.buttonLogin -> login(etUsername.text.toString(), etPassword.text.toString())
            R.id.buttonFunctions -> startActivity<WikiAct>()
        }
    }
}
