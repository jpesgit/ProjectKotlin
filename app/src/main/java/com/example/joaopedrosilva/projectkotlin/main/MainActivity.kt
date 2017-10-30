package com.example.joaopedrosilva.projectkotlin.main

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.example.joaopedrosilva.projectkotlin.R
import com.example.joaopedrosilva.projectkotlin.utils.startActivity
import com.example.joaopedrosilva.projectkotlin.utils.toast
import kotlinx.android.synthetic.main.activity_main.*

/**\
 * 1: Line breaks na class declaration se implementar mts interfaces. Neste caso pode ficar num linha só
 * 2: Ordem dos métodos:
 * -- lifecycle methods
 * -- implemented methods
 * -- public methods
 * -- private methods
 * -- extension functions
 *
 * 3: podes converter o setText para text = ...
 * 4: extension function definidas na classe devem ser private. por a extensão num ficheiro á parte (top level func)
 * 5: login private?
 * 6: startActivity = a 4
 *
 */
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
            startActivity<ThirdActivity>()
        } else {
            toast("try again")
        }
    }


    override fun onClick(v: View) {
        when (v.id) {
            R.id.buttonLogin -> {
                login(etUsername.text.toString(), etPassword.text.toString())
            }

            R.id.buttonFunctions -> {
                startActivity<SecondActivity>()
            }
        }

    }


}
