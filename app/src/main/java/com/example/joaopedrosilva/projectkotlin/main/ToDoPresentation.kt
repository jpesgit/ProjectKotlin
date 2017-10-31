package com.example.joaopedrosilva.projectkotlin.main

import com.example.joaopedrosilva.projectkotlin.data.Task

/**
 * Created by joaopedrosilva on 30/10/17.
 */
interface ToDoPresentation {
    fun adapterDataChanged(tasks: List<Task>)
}