package com.example.jogodavelha

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class SelecaoXMaquina : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_selecao_xmaquina)

        var killSelected = findViewById<ImageButton>(R.id.killuaSelected)
        var gonSelected = findViewById<ImageButton>(R.id.gonSelected)

        killSelected.setOnClickListener {

            val intent = Intent(this,PlayerSelectedMaquina::class.java)

            intent.putExtra("killua", "0")

            startActivity(intent)

        }

        gonSelected.setOnClickListener {

            val intent = Intent(this,PlayerSelectedMaquina::class.java)

            intent.putExtra("gon", "1")

            startActivity(intent)
        }
    }
}