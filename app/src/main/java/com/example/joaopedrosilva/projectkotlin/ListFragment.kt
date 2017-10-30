package com.example.joaopedrosilva.projectkotlin


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_plus_one.*


class ListFragment : Fragment() {
    var TAG = ListFragment.javaClass.canonicalName

    companion object {
        fun newInstance(): ListFragment {
            return ListFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_plus_one, container, false)

        return view
    }

    override fun onResume() {
        super.onResume()
        //extension function
        val text = "this is my text".convertSpacesToUnderscores()
        tvExtensionFuncitons.setText(text)
        //Inline functions
        tvIinlineFunctions.text = inline()
        //Sealed classes
        val ui = Ui() +
                UiOp.Show +
                UiOp.TranslateX(20f) +
                UiOp.TranslateY(40f)
        UiOp.ScrollView(60f)

        run(scaleadclass, ui)

    }


}


/**
 * sealed classses
 */
sealed class UiOp {
    object Show : UiOp()
    object Hide : UiOp()
    class TranslateX(val px: Float) : UiOp()
    class TranslateY(val px: Float) : UiOp()
    class ScrollView(val px: Float) : UiOp()
}

fun execute(view: View, op: UiOp) = when (op) {
    UiOp.Show -> view.visibility = View.VISIBLE
    UiOp.Hide -> view.visibility = View.GONE
    is UiOp.TranslateX -> view.translationX = op.px
    is UiOp.TranslateY -> view.translationY = op.px
    is UiOp.ScrollView -> view.cameraDistance = op.px
}

class Ui(val uiOps: List<Any> = emptyList()) {
    operator fun plus(uiOp: UiOp) = Ui(uiOps + uiOp)
}

fun run(view: View, ui: Ui) {
    ui.uiOps.forEach { execute(view, it as UiOp) }
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
