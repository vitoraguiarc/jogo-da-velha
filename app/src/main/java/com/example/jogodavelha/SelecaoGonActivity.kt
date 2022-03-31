package com.example.jogodavelha

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class SelecaoGonActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_selecao_gon)
    }

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

    //Array das jogadas de cada jogador
    var gonPlayer = ArrayList<Int>()
    var killPlayer = ArrayList<Int>()

    //Vez do jogador
    var playerActive = 1


    fun playGame(cellId: Int, btnSelecionado: Button) {

        if (playerActive == 1) {
            btnSelecionado.background = getDrawable(R.drawable.gonselect)
            gonPlayer.add(cellId)
            playerActive = 2
        } else {
            btnSelecionado.background = getDrawable(R.drawable.killselect)
            killPlayer.add(cellId)
            playerActive = 1
        }

        btnSelecionado.isEnabled = false
        checarVencedor()
    }

    fun checarVencedor() {
        var vencedor = 0

        if (
            gonPlayer.contains(1) && gonPlayer.contains(2) && gonPlayer.contains(3) ||
            gonPlayer.contains(4) && gonPlayer.contains(5) && gonPlayer.contains(6) ||
            gonPlayer.contains(7) && gonPlayer.contains(8) && gonPlayer.contains(9) ||
            gonPlayer.contains(1) && gonPlayer.contains(4) && gonPlayer.contains(7) ||
            gonPlayer.contains(2) && gonPlayer.contains(5) && gonPlayer.contains(8) ||
            gonPlayer.contains(3) && gonPlayer.contains(6) && gonPlayer.contains(9) ||
            gonPlayer.contains(1) && gonPlayer.contains(5) && gonPlayer.contains(9) ||
            gonPlayer.contains(3) && gonPlayer.contains(5) && gonPlayer.contains(7)
        ) {
            vencedor = 1

        } else if (
            killPlayer.contains(1) && killPlayer.contains(2) && killPlayer.contains(3) ||
            killPlayer.contains(4) && killPlayer.contains(5) && killPlayer.contains(6) ||
            killPlayer.contains(7) && killPlayer.contains(8) && killPlayer.contains(9) ||
            killPlayer.contains(1) && killPlayer.contains(4) && killPlayer.contains(7) ||
            killPlayer.contains(2) && killPlayer.contains(5) && killPlayer.contains(8) ||
            killPlayer.contains(3) && killPlayer.contains(6) && killPlayer.contains(9) ||
            killPlayer.contains(1) && killPlayer.contains(5) && killPlayer.contains(9) ||
            killPlayer.contains(3) && killPlayer.contains(5) && killPlayer.contains(7)
        ) {
            vencedor = 2
        } else {
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
            }
        }

    }

}
//        //LINHAS
//
//        //Conferindo a linha 1
//
//        if (gonPlayer.contains(1) && gonPlayer.contains(2) && gonPlayer.contains(3))
//            vencedor = 1
//
//        if (killPlayer.contains(1) && killPlayer.contains(2) && killPlayer.contains(3))
//            vencedor = 2
//
//        //Conferindo a linha 2
//
//        if (gonPlayer.contains(4) && gonPlayer.contains(5) && gonPlayer.contains(6))
//            vencedor = 1
//
//        if (killPlayer.contains(4) && killPlayer.contains(5) && killPlayer.contains(6))
//            vencedor = 2
//
//        //Conferindo a linha 3
//
//        if (gonPlayer.contains(7) && gonPlayer.contains(8) && gonPlayer.contains(9))
//            vencedor = 1
//
//        if (killPlayer.contains(7) && killPlayer.contains(8) && killPlayer.contains(9))
//            vencedor = 2
//
//        //COLUNAS
//
//        //Conferindo a coluna 1
//        if (gonPlayer.contains(1) && gonPlayer.contains(4) && gonPlayer.contains(7))
//            vencedor = 1
//
//        if (killPlayer.contains(1) && killPlayer.contains(4) && killPlayer.contains(7))
//            vencedor = 2
//
//        //Conferindo a coluna 2
//        if (gonPlayer.contains(2) && gonPlayer.contains(5) && gonPlayer.contains(8))
//            vencedor = 1
//
//        if (killPlayer.contains(2) && killPlayer.contains(5) && killPlayer.contains(8))
//            vencedor = 2
//
//        //Conferindo a coluna 2
//        if (gonPlayer.contains(3) && gonPlayer.contains(6) && gonPlayer.contains(9))
//            vencedor = 1
//
//        if (killPlayer.contains(3) && killPlayer.contains(6) && killPlayer.contains(9))
//            vencedor = 2
//
//        //DIAGONAIS
//
//        //Conferindo a diagonal partindo da direita
//        if (gonPlayer.contains(1) && gonPlayer.contains(5) && gonPlayer.contains(9))
//            vencedor = 1
//
//        if (killPlayer.contains(1) && killPlayer.contains(5) && killPlayer.contains(9))
//            vencedor = 2
//
//        //Conferindo a diagonal partindo da esquerda
//        if (gonPlayer.contains(3) && gonPlayer.contains(5) && gonPlayer.contains(7))
//            vencedor = 1
//
//        if (killPlayer.contains(3) && killPlayer.contains(5) && killPlayer.contains(7))
//            vencedor = 2




//    }
