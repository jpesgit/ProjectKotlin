package com.example.joaopedrosilva.projectkotlin.main

import com.example.joaopedrosilva.projectkotlin.data.Task

interface ToDoPresentation {
    fun adapterDataChanged(tasks: List<Task>)
}