package com.soms.todoapp

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

/**
 * Created by somasundaram on 24/09/17.
 */

class TodoAdapter(private val data: ArrayList<String>) : RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): TodoViewHolder {
        return TodoViewHolder(LayoutInflater.from(parent?.context)
                .inflate(R.layout.single_item, parent, false))
    }

    override fun onBindViewHolder(holder: TodoViewHolder?, position: Int) {
        holder?.todoText?.text = data[position]
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class TodoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        internal val todoText: TextView = view.findViewById(R.id.todo_item)
    }
}