package com.example.joaopedrosilva.projectkotlin.main

import android.util.Log
import com.example.joaopedrosilva.projectkotlin.data.Task
import com.example.joaopedrosilva.projectkotlin.data.TaskDao
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class ToDoPresenter (
        val taskDao: TaskDao,
        val presentation: ToDoPresentation
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
                // não deves aceder ao dao directamente, mas atraves
                // de um manager qualquer (eg: DatabaseManager)
                taskDao.getAllTasks()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(
                                { dbTaks ->
//                                    tasks.clear()
//                                    tasks.addAll(dbTaks)

                                    // um bocado confusa esta extension function
                                    // n se percebe ao inicio o que queres fazer

                                    if(dbTaks.isNotEmpty()){
                                        presentation.adapterDataChanged(dbTaks)
                                    }

                                    /*(tasks.size - 1).takeIf { it >= 0 }?.let {
                                        presentation?.taskAddedAt(it)
                                        presentation?.scrollTo(it)
                                    }*/
                                },
                                // n te esqueças de logar sempre os erros
                                {
                                    Log.e(TAG, "whatever message", it)
                                })
        )

        // isto n deve estar aqui.
//        presentation?.showTasks(tasks)
    }

    fun addNewTask(taskDescription: String) {
        val newTask = Task(false, description = taskDescription)

        compositeDisposable.add(
                Observable.fromCallable { taskDao.insertTask(newTask) }
                .subscribeOn(Schedulers.io())
                        // n precisas disto
                        // n vais fazer nada na main thread
//                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { Log.i(TAG, "Task added")},
                        { Log.e(TAG, "Sth error message", it)}
                )
        )
    }
}