package com.soms.todoapp

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Menu
import android.view.MenuItem

import kotlinx.android.synthetic.main.activity_main.*
import android.widget.Toast
import android.support.v7.app.AlertDialog
import android.widget.LinearLayout
import android.widget.EditText


class MainActivity : AppCompatActivity() {

    private var todoAdapter: TodoAdapter? = null
    private var appDatabase: AppDatabase? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)


        val recyclerView = findViewById<RecyclerView>(R.id.todoRecylerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        todoAdapter = TodoAdapter(ArrayList())
        appDatabase = AppDatabase.getDatabase(this.application)
        appDatabase?.taskDao()?.loadAllTasks()?.observe(this, Observer<List<Task>> { tasks ->
            val newTasks = ArrayList<Task>()
            if (tasks != null) {
                newTasks.addAll(tasks)
            }
            todoAdapter?.setTasks(newTasks)
        })

        recyclerView.adapter = todoAdapter


        fab.setOnClickListener { showDialog() }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun showDialog() {
        val alertDialog = AlertDialog.Builder(this@MainActivity)
        alertDialog.setTitle("Task")
        alertDialog.setMessage("Create a task")

        val input = EditText(this@MainActivity)
        val lp = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT)
        input.layoutParams = lp
        alertDialog.setView(input)

        alertDialog.setPositiveButton("Create",
                { _, _ ->
                    val taskName = input.text.toString()
                    val task = Task(taskName = taskName)
                    appDatabase?.taskDao()?.insertTask(task)
                    Toast.makeText(this@MainActivity, "$taskName created", Toast.LENGTH_SHORT).show()
                })

        alertDialog.setNegativeButton("Cancel",
                { dialog, _ -> dialog.cancel() })
        alertDialog.show()
    }
}
