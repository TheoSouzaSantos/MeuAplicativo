package com.example.aula1

import android.os.Bundle
import android.os.PersistableBundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val itens = mutableListOf<String>()

        val listaPessoas = findViewById<ListView>(R.id.listaPessoas)
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, itens)
        listaPessoas.adapter = adapter

        val pessoaescrita = findViewById<TextInputEditText>(R.id.pessoa)

        val adicionarPessoa = findViewById<Button>(R.id.adicionarPessoa)
        val removerPessoa = findViewById<Button>(R.id.removerPessoa)

        adicionarPessoa.setOnClickListener {

            val pessoa: String = pessoaescrita.text.toString()
            if(itens.isEmpty() && pessoa.trim() == ""){

            }
            itens.add(pessoa.trim())
            adapter.notifyDataSetChanged()
            pessoaescrita.text?.clear()
        }

        removerPessoa.setOnClickListener {

            val pessoa: String = pessoaescrita.text.toString()
            if(itens.isNotEmpty()) {
                if (pessoa.trim() != "") {
                    if(itens.remove(pessoa.trim())){
                        itens.remove(pessoa.trim())
                    }else {
                        Toast.makeText(
                            this,
                            R.string.txt_pessoanaoexiste,
                            Toast.LENGTH_SHORT).show()
                    }
                } else {
                    itens.removeAt(itens.size - 1)
                }
            } else {
                Toast.makeText(
                    this,
                    R.string.txt_listavaziaR,
                    Toast.LENGTH_SHORT).show()
            }
            adapter.notifyDataSetChanged()
            pessoaescrita.text?.clear()
        }


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.menu_principal, menu)
        return true

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.item_configuracao -> {
                Toast.makeText(
                    this@MainActivity,
                    R.string.txt_addconfig,
                    Toast.LENGTH_LONG
                ).show()
            }
            R.id.item_sobre -> {
                Toast.makeText(
                    this@MainActivity,
                    R.string.txt_addsobre,
                    Toast.LENGTH_LONG
                ).show()
            }
        }
        return super.onOptionsItemSelected(item)
    }


}