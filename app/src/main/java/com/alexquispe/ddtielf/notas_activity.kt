package com.alexquispe.ddtielf

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import java.io.File

class notas_activity : AppCompatActivity() {

    private lateinit var editTextTitle: EditText
    private lateinit var editTextNote: EditText
    private lateinit var buttonSave: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notas)

        editTextTitle = findViewById(R.id.editTextTitle)
        editTextNote = findViewById(R.id.editTextNote)
        buttonSave = findViewById(R.id.buttonSave)

        val noteTitle = intent.getStringExtra("NOTE_TITLE")
        if (noteTitle != null) {
            loadNote(noteTitle)
        }

        buttonSave.setOnClickListener {
            saveNote()
        }
    }

    private fun loadNote(title: String) {
        val file = File(filesDir, "$title.txt")
        if (file.exists()) {
            editTextTitle.setText(title)
            editTextNote.setText(file.readText())
        }
    }

    private fun saveNote() {
        val title = editTextTitle.text.toString()
        val noteText = editTextNote.text.toString()

        if (title.isNotEmpty() && noteText.isNotEmpty()) {
            val file = File(filesDir, "$title.txt")
            file.writeText(noteText)

            val intent = Intent(this, NotasListActivity::class.java)
            startActivity(intent)
        } else {
            // Mostrar mensaje de error
        }
    }
}
