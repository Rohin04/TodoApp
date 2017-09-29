package com.soms.todoapp

import android.arch.persistence.room.Entity

/**
 * Created by somasundaram on 29/09/17.
 */
@Entity(tableName = "tasks")
data class Task(val id: Long, val taskName: String, val isCompleted: Boolean = false)