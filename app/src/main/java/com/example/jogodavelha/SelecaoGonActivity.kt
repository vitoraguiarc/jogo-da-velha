package com.example.jogodavelha

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast

class SelecaoGonActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_selecao_gon)

        var selecionadoPlayer = findViewById<ImageView>(R.id.selected)
        val intent: Intent = getIntent() // pegando da area de transferencia
        var kill = intent.getStringExtra("killua")
        var turno = findViewById<ImageView>(R.id.jogador)
        if (kill == "0") {
            selecionadoPlayer.setBackgroundResource(R.drawable.killselect)
            turno.setBackgroundResource(R.drawable.killselect)
        } else {
            selecionadoPlayer.setBackgroundResource(R.drawable.gonselect)
            turno.setBackgroundResource(R.drawable.gonselect)
        }

    }

    var contador = 0

    //Array das jogadas de cada jogador
    var gonPlayer = ArrayList<Int>()
    var killPlayer = ArrayList<Int>()

    fun btnClick(view: View) {

        val btnSelecionado = view as Button
        var cellId = 0

        when (btnSelecionado.id) {
            R.id.quadrado1 -> cellId = 1
            R.id.quadrado2 -> cellId = 2
            R.id.quadrado3 -> cellId = 3
            R.id.quadrado4 -> cellId = 4
            R.id.quadrado5 -> cellId = 5
            R.id.quadrado6 -> cellId = 6
            R.id.quadrado7 -> cellId = 7
            R.id.quadrado8 -> cellId = 8
            R.id.quadrado9 -> cellId = 9
        }

        // Toast.makeText(this, "ID "+cellId, Toast.LENGTH_LONG).show()
        playGame(cellId, btnSelecionado)

    }



    //Vez do jogador
    var playerActive = 1


    fun playGame(cellId: Int, btnSelecionado: Button) {

        contador++

        var turno = findViewById<ImageView>(R.id.jogador)

            if (playerActive == 2) {

                turno.setBackgroundResource(R.drawable.killselect)
                btnSelecionado.background = getDrawable(R.drawable.killselect)
                gonPlayer.add(cellId)
                playerActive = 1
                turno.setBackgroundResource(R.drawable.gonselect)

            } else {
                btnSelecionado.background = getDrawable(R.drawable.gonselect)
                killPlayer.add(cellId)
                playerActive = 2
                turno.background = getDrawable(R.drawable.killselect)
            }

        btnSelecionado.isEnabled = false
        checarVencedor()

        }



    fun verificarPlayer(player: ArrayList<Int>): Boolean {

           return player.contains(1) && player.contains(2) && player.contains(3) ||
                player.contains(4) && player.contains(5) && player.contains(6) ||
                player.contains(7) && player.contains(8) && player.contains(9) ||
                player.contains(1) && player.contains(4) && player.contains(7) ||
                player.contains(2) && player.contains(5) && player.contains(8) ||
                player.contains(3) && player.contains(6) && player.contains(9) ||
                player.contains(1) && player.contains(5) && player.contains(9) ||
                player.contains(3) && player.contains(5) && player.contains(7)
    }

    fun checarVencedor() {
        var vencedor = 0

        if ( verificarPlayer(killPlayer)){
            vencedor = 1

        } else if ( verificarPlayer(gonPlayer) ) {
            vencedor = 2
        }
        else if( contador >= 9 && vencedor == 0) {
            vencedor = 3
        }

        //VENCEDOR
        if (vencedor != 0) {
            if (vencedor == 1) {
                val intent = Intent(this, VitoriaGonActivity::class.java)
                startActivity(intent)
            } else if (vencedor == 2) {
                val intent = Intent(this, VitoriaKilluaActivity::class.java)
                startActivity(intent)
            } else if (vencedor == 3) {
                val intent = Intent(this, EmpateActivity::class.java)
                startActivity(intent)
            }
        }

    }

}


