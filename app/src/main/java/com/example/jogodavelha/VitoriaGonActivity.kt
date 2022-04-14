package com.example.jogodavelha

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class VitoriaGonActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vitoria_gon)

        var newGame = findViewById<Button>(R.id.jogarNovamente)
        var vencedor = findViewById<TextView>(R.id.vitorioso)
        var imgVencedor = findViewById<ImageView>(R.id.imgVitorioso)
        val intent: Intent = getIntent()
        var gon = intent.getStringExtra("gonW")
        var killua = intent.getStringExtra("killW")

        if (gon == "10") {
            vencedor.setText("VENCEDOR")
            imgVencedor.setBackgroundResource(R.drawable.gonwinner)
        } else if (killua == "20") {
            vencedor.setText("VENCEDOR")
            imgVencedor.setBackgroundResource(R.drawable.killuawinner)
        } else {
            vencedor.setText("DEU VELHA")
            imgVencedor.setBackgroundResource(R.drawable.empate)
        }

        newGame.setOnClickListener {
            val intent = Intent(this,SelecaoActivity::class.java)
            startActivity(intent)
        }
    }
}