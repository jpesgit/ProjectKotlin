package com.example.joaopedrosilva.projectkotlin.main

import com.example.joaopedrosilva.projectkotlin.data.Task

/**
 * Created by joaopedrosilva on 30/10/17.
 */
interface ToDoPresentation {
    fun showTasks(tasks: List<Task>)

    fun taskAddedAt(position: Int)

    fun scrollTo(position: Int)
}