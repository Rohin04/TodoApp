package com.soms.todoapp

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Created by somasundaram on 29/09/17.
 */
@Entity(tableName = "tasks")
data class Task(@PrimaryKey(autoGenerate = true) val id: Long? = null, val taskName: String, val isCompleted: Boolean = false)