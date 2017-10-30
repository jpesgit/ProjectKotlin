package com.example.joaopedrosilva.projectkotlin.data

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase

/**
 * Created by joaopedrosilva on 30/10/17.
 */
@Database(entities = arrayOf(Task::class), version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun taskDao(): TaskDao
}