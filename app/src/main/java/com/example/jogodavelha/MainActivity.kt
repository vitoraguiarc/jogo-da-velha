package com.example.jogodavelha

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val jogadorX = findViewById<TextView>(R.id.jogadorx)

        jogadorX.setOnClickListener{

            val intent = Intent (this, SelecaoActivity::class.java)

            startActivity(intent)

        }



    }
}