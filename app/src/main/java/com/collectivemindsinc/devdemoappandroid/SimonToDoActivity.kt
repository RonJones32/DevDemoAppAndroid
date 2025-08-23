package com.collectivemindsinc.devdemoappandroid

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.Date

class SimonToDoActivity : Activity() {
    var data = ArrayList<ToDoItem>()
    lateinit var simonToDoAdapter: SimonToDoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simon_to_do)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val numItems = findViewById<TextView>(R.id.numItems)
        val plusButton = findViewById<Button>(R.id.plus)
        val simonToDo = findViewById<TextView>(R.id.simonToDo)
        val toDoList = findViewById<RecyclerView>(R.id.toDoList)
        val back = findViewById<Button>(R.id.back)

        toDoList.layoutManager = LinearLayoutManager(this)

        data.add(ToDoItem("first task", Date()))
        data.add(ToDoItem("second task", Date()))
        data.add(ToDoItem("third task", Date()))

        val adapter = SimonToDoAdapter(data,this)
        toDoList.adapter = adapter

        numItems.text = adapter.itemCount.toString()

        back.setOnClickListener {
            //declaring intent to open new screen
            finish()
            val intent = Intent(this, ResponseActivity::class.java)
            startActivity(intent)

        }
    }
}