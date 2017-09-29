package com.soms.todoapp

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Created by somasundaram on 29/09/17.
 */
@Entity(tableName = "tasks")
data class Task(@PrimaryKey(autoGenerate = true) var id: Long? = null, var taskName: String, var isCompleted: Boolean = false)