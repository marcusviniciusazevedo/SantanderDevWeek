package com.example.santanderdevweek.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.ViewModelProvider
import com.example.santanderdevweek.R

class MainActivity : AppCompatActivity() {

    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

        mainViewModel = ViewModelProvider(owner:this).get(MainViewModel::class.java)
        mainViewModel.buscarContaCliente().observe(owner:this, Observer { result ->
        })
    }

    fun bindOnView() {
        findViewById<TextView>(R.id.tv_agencia).text = result.agencia
        findViewById<TextView>(R.id.tv_conta_corrente).text = result.numero
        findViewById<TextView>(R.id.tv_saldo).text = result.saldo
        findViewById<TextView>(R.id.tv_limite).text = result.limite
        findViewById<TextView>(R.id.tv_usuario).text = result.cliente.nome
        findViewById<TextView>(R.id.tv_cartao_final_value).text = result.cartao.numeroCartao

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflate = menuInflater
        inflate.inflate(R.menu.main_menu, menu)
        return true
    }

}