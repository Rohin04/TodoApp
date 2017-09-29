package com.soms.todoapp

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context

/**
 * Created by somasundaram on 29/09/17.
 */
@Database(entities = arrayOf(Task::class), version = 1)
abstract class AppDatabase : RoomDatabase() {

    companion object {

        private lateinit var INSTANCE: AppDatabase

        private val DATABASE_NAME = "task-db"

        fun getDatabase(context: Context): AppDatabase {
            INSTANCE = Room.databaseBuilder(context.applicationContext,
                    AppDatabase::class.java, DATABASE_NAME)
                    .allowMainThreadQueries()
                    .build()
            return INSTANCE
        }
    }
}