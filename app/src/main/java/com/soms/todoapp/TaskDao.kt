package com.soms.todoapp

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.persistence.room.*

/**
 * Created by somasundaram on 29/09/17.
 */
@Dao
interface TaskDao {
    @Query("select * from tasks")
    fun loadAllTasks(): MutableLiveData<List<Task>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertTask(taskEntity: Task)

    @Update
    fun updateTask(task: Task)
}