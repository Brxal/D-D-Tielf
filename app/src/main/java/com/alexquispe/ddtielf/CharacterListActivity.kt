package com.alexquispe.ddtielf

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CharacterListActivity : AppCompatActivity() {

    private lateinit var dbHelper: CharacterDatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_character_list)

        dbHelper = CharacterDatabaseHelper(this)

        val recyclerView = findViewById<RecyclerView>(R.id.characterRecyclerView)
        val addMoreCharactersButton = findViewById<Button>(R.id.addMoreCharactersButton)
        val backToMenuButton = findViewById<Button>(R.id.backToMenuButton)

        // Obtener la lista de personajes desde la base de datos
        val characters = dbHelper.getAllCharacters()

        // Configurar el adaptador
        val adapter = CharacterAdapter(characters)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        // Configurar el clic del botón "Agregar más personajes"
        addMoreCharactersButton.setOnClickListener {
            val intent = Intent(this, CreateCharacterActivity::class.java)
            startActivity(intent)
        }

        // Configurar el clic del botón "Regresar al menú"
        backToMenuButton.setOnClickListener {
            val intent = Intent(this, menu_dd::class.java)
            startActivity(intent)
        }
    }
}

