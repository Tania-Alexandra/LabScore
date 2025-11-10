package com.example.labscore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import android.content.Intent

class AddUserActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_user)

        val nombre = findViewById<EditText>(R.id.etNombre)
        val apellido = findViewById<EditText>(R.id.etApellido)
        val userId = findViewById<EditText>(R.id.etUserId)
        val correo = findViewById<EditText>(R.id.etCorreo)
        val recCorreo = findViewById<EditText>(R.id.etCorreoRecuperacion)
        val pass = findViewById<EditText>(R.id.etPass)
        val pass2 = findViewById<EditText>(R.id.etPass2)
        val check = findViewById<CheckBox>(R.id.checkTerminos)
        val btnGuardar = findViewById<Button>(R.id.btnGuardar)
        val volver = findViewById<TextView>(R.id.tvVolver)

        btnGuardar.setOnClickListener {
            if (nombre.text.toString().isEmpty() ||
                correo.text.toString().isEmpty() ||
                pass.text.toString().isEmpty()) {
                Toast.makeText(this, "Completa todos los campos", Toast.LENGTH_SHORT).show()
            } else if (pass.text.toString() != pass2.text.toString()) {
                Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show()
            } else if (!check.isChecked) {
                Toast.makeText(this, "Debes aceptar los términos", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Usuario registrado con éxito 💜", Toast.LENGTH_SHORT).show()
            }
        }

        volver.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}