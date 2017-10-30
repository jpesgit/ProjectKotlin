package com.example.joaopedrosilva.projectkotlin.main

import com.example.joaopedrosilva.projectkotlin.R
import com.example.joaopedrosilva.projectkotlin.data.Task
import kotlinx.android.synthetic.main.item_to_do.view.*

/**
 * Created by joaopedrosilva on 30/10/17.
 */
class TaskAdapter(var tasks: List<Task>) : android.support.v7.widget.RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {

    override fun onCreateViewHolder(parent: android.view.ViewGroup, type: Int): TaskAdapter.TaskViewHolder {
        return TaskViewHolder(parent)
    }

    override fun onBindViewHolder(viewHolder: TaskAdapter.TaskViewHolder, position: Int) {
        viewHolder.bind(tasks[position])
    }

    override fun getItemCount(): Int = tasks.size

    inner class TaskViewHolder(parent: android.view.ViewGroup) : android.support.v7.widget.RecyclerView.ViewHolder(android.view.LayoutInflater.from(parent.context).inflate(R.layout.item_to_do, parent, false)) {

        fun bind(task: Task) = with(itemView) {
            task_cb.text = task.description
            task_cb.isChecked = task.completed
        }
    }
}