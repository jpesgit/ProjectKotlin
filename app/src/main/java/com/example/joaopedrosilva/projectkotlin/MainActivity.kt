package com.example.joaopedrosilva.projectkotlin

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

    class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        welcomeMessage.setText(getString(R.string.app_name))

        buttonLogin.setOnClickListener{
            login(etUsername.text.toString(),etPassword.text.toString())
        }


    }
    fun login(user:String , pass:String){
        if(user.equals("a")&& pass.equals("a")) {
            Toast.makeText(this, "Success", Toast.LENGTH_LONG).show()
            val intent = Intent(this@MainActivity, SecondActivity::class.java)
            startActivity(intent)
        }else{
            Toast.makeText(this, "Try again", Toast.LENGTH_LONG).show()
        }
    }
}
