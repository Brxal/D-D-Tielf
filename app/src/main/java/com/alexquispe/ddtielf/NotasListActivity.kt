package com.alexquispe.ddtielf

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.io.File

class NotasListActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: NotasAdapter
    private lateinit var emptyView: TextView
    private lateinit var fabAddNote: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notas_list)

        recyclerView = findViewById(R.id.recyclerView)
        emptyView = findViewById(R.id.emptyView)
        fabAddNote = findViewById(R.id.fabAddNote)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val notes = loadNotes()
        if (notes.isEmpty()) {
            emptyView.visibility = TextView.VISIBLE
            recyclerView.visibility = RecyclerView.GONE
        } else {
            emptyView.visibility = TextView.GONE
            recyclerView.visibility = RecyclerView.VISIBLE
        }

        adapter = NotasAdapter(notes) { noteTitle ->
            val intent = Intent(this, notas_activity::class.java).apply {
                putExtra("NOTE_TITLE", noteTitle)
            }
            startActivity(intent)
        }
        recyclerView.adapter = adapter

        fabAddNote.setOnClickListener {
            val intent = Intent(this, notas_activity::class.java)
            startActivity(intent)
        }
    }

    private fun loadNotes(): List<String> {
        val notesDir = filesDir
        return notesDir.list()?.map { it.removeSuffix(".txt") } ?: emptyList()
    }
}



