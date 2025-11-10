package com.example.labscore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import android.content.Intent


class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val btnEditar = findViewById<Button>(R.id.btnEditar)
        val btnCerrar = findViewById<Button>(R.id.btnCerrar)

        btnEditar.setOnClickListener {
            Toast.makeText(this, "Función editar perfil (próximamente)", Toast.LENGTH_SHORT).show()
        }

        btnCerrar.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
