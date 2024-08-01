package com.alexquispe.ddtielf

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class menu_dd : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu_dd)

        val botonN = findViewById<Button>(R.id.notas)
        botonN.setOnClickListener {
            val intent = Intent(this, NotasListActivity::class.java)
            startActivity(intent)
        }

        val logOutButton = findViewById<Button>(R.id.logOutButton)
        logOutButton.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            Log.d("menu_dd", "User signed out")

            val intent = Intent(this, AuthActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
            finish()
        }

        val contentPdfButton = findViewById<Button>(R.id.contentpdf)
        contentPdfButton.setOnClickListener {
            val pdfUrl = "https://huertadesolymar.uy/D%26D5Manual.pdf"
            val intent = Intent(this, PdfViewerActivity::class.java).apply {
                putExtra("pdfUrl", pdfUrl)
            }
            startActivity(intent)
        }

        val rollDiceButton = findViewById<Button>(R.id.rollDice)
        rollDiceButton.setOnClickListener {
            val intent = Intent(this, DiceRollerActivity::class.java)
            startActivity(intent)
        }
    }
}
