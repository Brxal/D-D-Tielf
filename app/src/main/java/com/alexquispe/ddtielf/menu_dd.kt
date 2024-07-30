package com.alexquispe.ddtielf

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class menu_dd : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_dd)

        val botonN = findViewById<Button>(R.id.notas)
        botonN.setOnClickListener {
            val intent = Intent(this, notas_activity::class.java)
            startActivity(intent)
        }
    }
}
