package com.example.jogodavelha

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class SelecaoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_selecao)

        val killSelected = findViewById<ImageButton>(R.id.killuaSelected)
        val gonSelected = findViewById<ImageButton>(R.id.gonSelected)

        killSelected.setOnClickListener {

            val intent = Intent(this,SelecaoKilluaActivity::class.java)

            startActivity(intent)

        }

        gonSelected.setOnClickListener {

            val intent = Intent(this,SelecaoGonActivity::class.java)

            startActivity(intent)
        }


    }
}