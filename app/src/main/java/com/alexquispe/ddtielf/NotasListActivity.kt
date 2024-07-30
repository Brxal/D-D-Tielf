package com.alexquispe.ddtielf

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.io.File

class NotasListActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: NotasAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notas_list)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val notes = loadNotes()
        adapter = NotasAdapter(notes) { noteTitle ->
            val intent = Intent(this, notas_activity::class.java).apply {
                putExtra("NOTE_TITLE", noteTitle)
            }
            startActivity(intent)
        }
        recyclerView.adapter = adapter
    }

    private fun loadNotes(): List<String> {
        val notesDir = filesDir
        return notesDir.list()?.map { it.removeSuffix(".txt") } ?: emptyList()
    }
}
