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

class LoginActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //button listener
        val button = findViewById<Button>(R.id.findSimon)
        button.setOnClickListener {
            //declaring intent to set up new page
            val intent = Intent(this, ResponseActivity::class.java)
            startActivity(intent)
            //finish()
        }

        //where to put finish()?

        val ronToDoButton = findViewById<Button>(R.id.ronToDo)
        ronToDoButton.setOnClickListener {
            val intent = Intent(this, RonToDoActivity::class.java)
            startActivity(intent)
        }
    }
}