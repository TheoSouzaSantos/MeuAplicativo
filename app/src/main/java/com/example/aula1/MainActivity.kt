package com.example.aula1

import android.os.Bundle
import android.os.PersistableBundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

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
                    "Item Configuração selecionado",
                    Toast.LENGTH_LONG
                ).show()
            }
            R.id.item_sobre -> {
                Toast.makeText(
                    this@MainActivity,
                    "Item Sobre selecionado",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}