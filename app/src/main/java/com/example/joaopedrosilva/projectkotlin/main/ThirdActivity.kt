package com.example.joaopedrosilva.projectkotlin.main

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.example.joaopedrosilva.projectkotlin.R
import com.example.joaopedrosilva.projectkotlin.data.Task
import com.facebook.stetho.Stetho
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_third.*
import javax.inject.Inject

/**
 * Created by joaopedrosilva on 30/10/17.
 */
class ThirdActivity : AppCompatActivity(), ToDoPresentation, View.OnClickListener {


    @Inject lateinit var presenter: ToDoPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        Stetho.initializeWithDefaults(this);
        AndroidInjection.inject(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)
        add_btn.setOnClickListener(this)
        tasks_rv.let {
            it.setHasFixedSize(true)
            it.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
            it.adapter = TaskAdapter(emptyList())
        }
        presenter.onCreate(this)
    }

    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()
    }

    override fun showTasks(tasks: List<Task>) {
        tasks_rv?.adapter = TaskAdapter(tasks)
    }

    override fun taskAddedAt(position: Int) {
        tasks_rv?.adapter?.notifyItemInserted(position)
    }

    override fun scrollTo(position: Int) {
        tasks_rv?.smoothScrollToPosition(position)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.add_btn -> {
                presenter.addNewTask(task_et.text.toString())
            }
        }
    }
}