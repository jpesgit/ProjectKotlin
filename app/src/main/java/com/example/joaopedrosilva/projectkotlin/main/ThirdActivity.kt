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

    private val taskAdapter = TaskAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        AndroidInjection.inject(this)
        Stetho.initializeWithDefaults(this)

        add_btn.setOnClickListener(this)
        tasks_rv.run {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@ThirdActivity, LinearLayoutManager.VERTICAL, false)
            adapter = taskAdapter
        }

        presenter.onCreate(this)
    }

    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()
    }

    override fun adapterDataChanged(tasks: List<Task>) {
        taskAdapter.setAdapterItems(tasks)
        tasks_rv.smoothScrollToPosition(0)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.add_btn -> {
                if (task_et.text.toString().isNotEmpty()) {
                    presenter.addNewTask(task_et.text.toString())
                    task_et.setText("")
                }
            }
        }
    }
}