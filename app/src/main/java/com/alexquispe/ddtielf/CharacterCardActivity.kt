package com.alexquispe.ddtielf

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class CharacterCardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_character_card)

        val characterName = intent.getStringExtra("characterName")
        val characterRace = intent.getStringExtra("characterRace")
        val characterClass = intent.getStringExtra("characterClass")
        val characterDescription = intent.getStringExtra("characterDescription")

        val nameTextView = findViewById<TextView>(R.id.characterName)
        val raceTextView = findViewById<TextView>(R.id.characterRace)
        val classTextView = findViewById<TextView>(R.id.characterClass)
        val descriptionTextView = findViewById<TextView>(R.id.characterDescription)
        val addMoreCharactersButton = findViewById<Button>(R.id.addMoreCharactersButton)

        nameTextView.text = characterName
        raceTextView.text = characterRace
        classTextView.text = characterClass
        descriptionTextView.text = characterDescription

        addMoreCharactersButton.setOnClickListener {
            // Navega de regreso a la pantalla de creación de personajes
            val intent = Intent(this, CreateCharacterActivity::class.java)
            startActivity(intent)
        }
    }
}

