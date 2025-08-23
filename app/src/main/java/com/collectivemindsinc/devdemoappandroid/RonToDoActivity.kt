package com.collectivemindsinc.devdemoappandroid

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ProgressBar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.size
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.Date

class RonToDoActivity : Activity() {
    private var progress = 0
    var data = ArrayList<ToDoItem>()
    lateinit var ronToDoAdapter: RonToDoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ron_to_do)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val progressBar = findViewById<ProgressBar>(R.id.progressBar)
        val plus = findViewById<Button>(R.id.plus)
        val toDoList = findViewById<RecyclerView>(R.id.toDoList)
        val back = findViewById<Button>(R.id.back)

        progressBar.progress = 0
        progressBar.max = 100

        toDoList.layoutManager = LinearLayoutManager(this)
        val adapter = RonToDoAdapter(data,this)
        plus.setOnClickListener {
            if(progress<100){
                progress+=25
                progressBar.progress = progress
            } else{
                progress = 0
                progressBar.progress = progress

                data.add(ToDoItem(adapter.itemCount.toString(),Date()))
                adapter.notifyItemInserted(adapter.itemCount)
            }
        }
        toDoList.adapter = adapter
        back.setOnClickListener {
            finish()
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}