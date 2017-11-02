package com.example.joaopedrosilva.projectkotlin.data

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "task")

data class Task(
        @ColumnInfo(name = "completed_flag")
        var completed: Boolean,
        @ColumnInfo(name = "task_desciption")
        var description: String
) {
    constructor() : this(false, UNKNOWN)

    companion object TO {
        val MASTER = 0
        val ROBOT = 1
        private val UNKNOWN = "" // just use for initializing
    }

    @field: PrimaryKey(autoGenerate = true)
    var id: Long = 0
}
//data class Task(@ColumnInfo(name = "completed_flag") var completed: Boolean = false,
//                @ColumnInfo(name = "task_desciption") var description: String) {
//    @ColumnInfo(name = "id")
//    @PrimaryKey(autoGenerate = true) var id: Long = 0
//}
