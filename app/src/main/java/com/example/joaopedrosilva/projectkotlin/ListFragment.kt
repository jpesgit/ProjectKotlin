package com.example.joaopedrosilva.projectkotlin


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup



class ListFragment : Fragment() {
    val TAG = javaClass.canonicalName

    companion object {
        fun newInstance(): ListFragment {
            return ListFragment()
        }
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_plus_one, container, false)

        return view
    }



}
