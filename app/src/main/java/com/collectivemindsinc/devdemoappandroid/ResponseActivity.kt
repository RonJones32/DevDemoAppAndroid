package com.collectivemindsinc.devdemoappandroid

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ResponseActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContentView(R.layout.activity_response)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //button listener
        val findRonButton = findViewById<Button>(R.id.findRon)
        findRonButton.setOnClickListener {
//            //declaring intent to open new screen
//            val intent = Intent(this, LoginActivity::class.java)
//            startActivity(intent)
            finish()
        }

        val simonToDoButton = findViewById<Button>(R.id.simonToDo)
        simonToDoButton.setOnClickListener {
            //declaring intent to open new screen
            val intent = Intent(this, SimonToDoActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}