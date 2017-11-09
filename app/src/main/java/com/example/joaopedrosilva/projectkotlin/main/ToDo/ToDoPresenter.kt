package com.example.joaopedrosilva.projectkotlin.main.ToDo

import android.util.Log
import com.example.joaopedrosilva.projectkotlin.data.Task
import com.example.joaopedrosilva.projectkotlin.data.TaskDao
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class ToDoPresenter (
        val taskDao: TaskDao,
        val activity: ToDoActivity
) {

    companion object {
        const val TAG = "ToDoPresenter.TAG"
    }

    val compositeDisposable = CompositeDisposable()

    fun onCreate() {
        loadTasks()
    }

    fun onDestroy() {
        compositeDisposable.dispose()
    }

    fun loadTasks() {
        compositeDisposable.add(
                taskDao.getAllTasks()
                        .subscribeOn(Schedulers.io())
                        .map<Results> { Results.Result(it) }


                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(
                                { result ->
                                    when (result) {
                                        is Results.Result -> activity.adapterDataChanged(result.items)

                                        is Results.ResultEmpty -> activity.adapterDataChanged(null)
                                    }
                                },
                                { error ->
                                    Log.i(TAG, "", error)
                                }

                        )
//                        .subscribe(
//                                { dbTaks ->
//                                    if(dbTaks.isNotEmpty()){
//                                        presentation.adapterDataChanged(dbTaks)
//                                    }
//                                },
//                                {
//                                    Log.e(TAG, "whatever message", it)
//                                })
        )

    }

    sealed class Results {
        object ResultEmpty : Results()
        class Result(val items: List<Task>) : Results()
    }
    fun addNewTask(taskDescription: String) {
        val newTask = Task(false, description = taskDescription)

        compositeDisposable.add(
                Observable.fromCallable { taskDao.insertTask(newTask) }
                .subscribeOn(Schedulers.io())
                .subscribe(
                        { Log.i(TAG, "Task added")},
                        { Log.e(TAG, "Sth error message", it)}
                )
        )
    }
}