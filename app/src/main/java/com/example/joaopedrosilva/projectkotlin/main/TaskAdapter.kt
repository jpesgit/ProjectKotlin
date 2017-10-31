package com.example.joaopedrosilva.projectkotlin.main

import android.support.v7.widget.RecyclerView
import com.example.joaopedrosilva.projectkotlin.R
import com.example.joaopedrosilva.projectkotlin.data.Task
import kotlinx.android.synthetic.main.item_to_do.view.*

class TaskAdapter : RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {

    private val tasks: MutableList<Task> = mutableListOf()

    override fun onCreateViewHolder(parent: android.view.ViewGroup, type: Int): TaskAdapter.TaskViewHolder {
        return TaskViewHolder(parent)
    }

    override fun onBindViewHolder(viewHolder: TaskAdapter.TaskViewHolder, position: Int) {
        viewHolder.bind(tasks[position])
    }

    fun setAdapterItems(items: List<Task>){
        this.tasks.clear()
        this.tasks.addAll(items)
    }

    override fun getItemCount(): Int = tasks.size

    // tira isto e poe no oncreateview (LayoutInflator...)
    inner class TaskViewHolder(parent: android.view.ViewGroup) : RecyclerView.ViewHolder(android.view.LayoutInflater.from(parent.context).inflate(R.layout.item_to_do, parent, false)) {

        fun bind(task: Task) = with(itemView) {
            task_cb.text = task.description
            task_cb.isChecked = task.completed
        }
    }
}