package com.example.jogodavelha

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class DificuldadeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dificuldade)

        var facil = findViewById<ImageView>(R.id.facil)

        facil.setOnClickListener {

            var intent = Intent(this, SelecaoXMaquina::class.java)
            startActivity(intent)
        }
    }
}