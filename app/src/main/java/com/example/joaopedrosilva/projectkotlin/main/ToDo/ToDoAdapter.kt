package com.example.joaopedrosilva.projectkotlin.main.ToDo

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import com.example.joaopedrosilva.projectkotlin.R
import com.example.joaopedrosilva.projectkotlin.data.Task
//import kotlinx.android.synthetic.main.item_to_do.view.*

class ToDoAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val tasks: MutableList<Task> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, type: Int): RecyclerView.ViewHolder {
//        var v = LayoutInflater.from(parent.context).inflate(R.layout.item_to_do, parent, false)
        // n ha motivo para n ser var!!
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_to_do, parent, false)
        return Item(v)
    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {
        (viewHolder as Item).bindData(tasks[position])
    }

    fun setAdapterItems(items: List<Task>?) {
        this.tasks.clear()
        if (items != null) {
            this.tasks.addAll(items)
        }


        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = tasks.size

    @Suppress("JoinDeclarationAndAssignment")
    class Item(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val task_cb: CheckBox

        init {
            this.task_cb = itemView.findViewById(R.id.task_cb)
        }

        // vê o bytecode que esta classe gerou.
        // as extensions não funcionam aqui
        // (o código que é gerado é um findViewById, o que só é preciso fazer 1 vez)
        fun bindData(task: Task) = with(itemView) {
            task_cb.text = task.description
            task_cb.isChecked = task.completed
        }
    }
}