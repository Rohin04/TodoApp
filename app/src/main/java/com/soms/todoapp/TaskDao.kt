package com.soms.todoapp

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*

/**
 * Created by somasundaram on 29/09/17.
 */
@Dao
interface TaskDao {
    @Query("select * from tasks")
    fun loadAllTasks(): LiveData<List<Task>>

    @Delete
    abstract fun deleteTask(taskEntity: Task)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract fun insertTask(taskEntity: Task)
}