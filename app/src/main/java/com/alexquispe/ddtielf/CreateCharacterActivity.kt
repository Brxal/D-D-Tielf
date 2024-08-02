package com.alexquispe.ddtielf

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity

class CreateCharacterActivity : AppCompatActivity() {

    private lateinit var dbHelper: CharacterDatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_character)

        dbHelper = CharacterDatabaseHelper(this)

        val characterName = findViewById<EditText>(R.id.characterName)
        val raceSpinner = findViewById<Spinner>(R.id.raceSpinner)
        val classSpinner = findViewById<Spinner>(R.id.classSpinner)
        val characterDescription = findViewById<EditText>(R.id.characterDescription)
        val saveCharacterButton = findViewById<Button>(R.id.saveCharacterButton)

        val races = listOf("Humano", "Elfo", "Enano", "Mediano", "Orco")
        val raceAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, races)
        raceAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        raceSpinner.adapter = raceAdapter

        val classes = listOf("Guerrero", "Mago", "Druida", "Ladrón", "Clérigo")
        val classAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, classes)
        classAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        classSpinner.adapter = classAdapter

        saveCharacterButton.setOnClickListener {
            val name = characterName.text.toString()
            val race = raceSpinner.selectedItem.toString()
            val characterClass = classSpinner.selectedItem.toString()
            val description = characterDescription.text.toString()

            val character = Character(name, race, characterClass, description)
            dbHelper.addCharacter(character)

            // Navegar a la pantalla de la lista de personajes
            val intent = Intent(this, CharacterListActivity::class.java)
            startActivity(intent)
        }
    }
}

