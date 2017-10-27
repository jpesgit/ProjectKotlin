package com.example.joaopedrosilva.projectkotlin

import android.content.DialogInterface
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity :
        AppCompatActivity(),
        View.OnClickListener {
    override fun onClick(v: View?) {
        login(etUsername.text.toString(), etPassword.text.toString())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        welcomeMessage.setText(getString(R.string.app_name))
        buttonLogin.setOnClickListener(this)



    }

    fun login(user: String, pass: String) {
        if (user == "a" && pass == "a") {
            Toast.makeText(this, "Success", Toast.LENGTH_LONG).show()
            startActivity(Intent(this, SecondActivity::class.java))
        } else {
            Toast.makeText(this, "Try again", Toast.LENGTH_LONG).show()
        }
    }
}
