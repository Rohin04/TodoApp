package com.soms.todoapp

import android.graphics.Paint
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import android.graphics.Paint.STRIKE_THRU_TEXT_FLAG



/**
 * Created by somasundaram on 24/09/17.
 */

class TodoAdapter(private val data: ArrayList<Task>) : RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {

    fun setTasks(taskList: ArrayList<Task>) {
        data.clear()
        data.addAll(taskList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): TodoViewHolder {
        return TodoViewHolder(LayoutInflater.from(parent?.context)
                .inflate(R.layout.single_item, parent, false))
    }

    override fun onBindViewHolder(holder: TodoViewHolder?, position: Int) {
        holder?.todoText?.text = data[position].taskName
        holder?.done?.isChecked = data[position].isCompleted
        if(data[position].isCompleted){
            holder?.todoText?.paintFlags = holder?.todoText?.paintFlags?.or(Paint.STRIKE_THRU_TEXT_FLAG)!!
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class TodoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        internal val todoText: TextView = view.findViewById(R.id.todo_item)
        internal val done: CheckBox = view.findViewById(R.id.done)
    }
}