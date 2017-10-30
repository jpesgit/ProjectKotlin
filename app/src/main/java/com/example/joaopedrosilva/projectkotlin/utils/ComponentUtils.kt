package com.example.joaopedrosilva.projectkotlin.utils

import android.app.Activity
import android.content.Intent
import android.widget.Toast

/**
 * Created by joaopedrosilva on 30/10/17.
 */


/**
 * Extensions Functions permitem adicionar novas funções às classes existentes
 *
 */
fun Activity.toast(message: CharSequence, duration: Int = Toast.LENGTH_LONG) {
    Toast.makeText(this, message, duration).show()
}

inline fun <reified T : Activity> Activity.startActivity() {
    startActivity(Intent(this, T::class.java))
}

/**
 *Inline functions
 */
inline fun <Int> addNumber(number: Int, body: (x: Int) -> Int): Int {
    return body(number)
}

fun inline(): String {
    return "${addNumber(number = 4) { x -> x + 4 }}"
}

/**
 *extension function
 */
fun String.convertSpacesToUnderscores(): String {
    return this.replace(" ", "_")
}
