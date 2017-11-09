package com.example.joaopedrosilva.projectkotlin.main.ToDo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView.LayoutManager
import android.view.View
import com.example.joaopedrosilva.projectkotlin.R
import com.example.joaopedrosilva.projectkotlin.data.Task
import com.facebook.stetho.Stetho
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_third.*
import javax.inject.Inject

class ToDoActivity : AppCompatActivity(), View.OnClickListener {

    @Inject lateinit var presenter: ToDoPresenter
    @Inject lateinit var myLayoutManager: LayoutManager
    @Inject lateinit var toDoAdapter: ToDoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        AndroidInjection.inject(this)
        Stetho.initializeWithDefaults(this)

        add_btn.setOnClickListener(this)
        tasks_rv.run {
            setHasFixedSize(true)
            layoutManager = myLayoutManager
            adapter = toDoAdapter
        }
        presenter.onCreate()
    }

    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()
    }

    fun adapterDataChanged(tasks: List<Task>?) {
        if (tasks != null) {
            toDoAdapter.setAdapterItems(tasks)
            tasks_rv.smoothScrollToPosition(0)
        } else {
            toDoAdapter.setAdapterItems(tasks)
        }
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.add_btn -> {
                if (task_et.text.toString().isNotEmpty()) {
                    presenter.addNewTask(task_et.text.toString())
                    task_et.setText("")
                }
            }
        }
    }
}