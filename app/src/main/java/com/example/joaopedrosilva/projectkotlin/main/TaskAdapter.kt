package com.example.joaopedrosilva.projectkotlin.main

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.joaopedrosilva.projectkotlin.R
import com.example.joaopedrosilva.projectkotlin.data.Task
import kotlinx.android.synthetic.main.item_to_do.view.*

class TaskAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val tasks: MutableList<Task> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, type: Int): RecyclerView.ViewHolder {
        var v = LayoutInflater.from(parent.context).inflate(R.layout.item_to_do, parent, false)
        return Item(v)
    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {
        (viewHolder as Item).bindData(tasks[position])
    }

    fun setAdapterItems(items: List<Task>) {
        this.tasks.clear()
        this.tasks.addAll(items)
    }

    override fun getItemCount(): Int = tasks.size

    class Item(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindData(task: Task) = with(itemView) {
            task_cb.text = task.description
            task_cb.isChecked = task.completed
        }
    }
}