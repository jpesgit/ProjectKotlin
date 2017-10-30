package com.example.joaopedrosilva.projectkotlin.data

import android.arch.persistence.room.*
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import io.reactivex.Flowable


@Dao
interface TaskDao {

    @Query("select * from task")
    fun getAllTasks(): Flowable<List<Task>>


    @Insert(onConflict = REPLACE)
    fun insertTask(task: Task)

    @Update(onConflict = REPLACE)
    fun updateTask(task: Task)

    @Delete
    fun deleteTask(task: Task)
}