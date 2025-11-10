package com.example.labscore.models

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

class SQLiteHelper(context: Context) :
    SQLiteOpenHelper(context, "LabScoreDB", null, 1) {

    override fun onCreate(db: SQLiteDatabase) {
        val createTable = """
            CREATE TABLE usuarios (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                nombre TEXT,
                apellido TEXT,
                userId TEXT,
                correo TEXT,
                recCorreo TEXT,
                pass TEXT
            );
        """.trimIndent()
        db.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS usuarios")
        onCreate(db)
    }

    //  Método para agregar al usuario
    fun addUser(
        nombre: String,
        apellido: String,
        userId: String,
        correo: String,
        recCorreo: String,
        pass: String,
        context: Context
    ): Boolean {
        val db = this.writableDatabase
        val values = ContentValues().apply {
            put("nombre", nombre)
            put("apellido", apellido)
            put("userId", userId)
            put("correo", correo)
            put("recCorreo", recCorreo)
            put("pass", pass)
        }

        val result = db.insert("usuarios", null, values)
        db.close()

        return if (result == -1L) {
            Toast.makeText(context, "❌ Error al guardar", Toast.LENGTH_SHORT).show()
            false
        } else {
            Toast.makeText(context, "✅ Usuario guardado con éxito", Toast.LENGTH_SHORT).show()
            true
        }
    }

    // Metodo para obtener al usuario

    fun getAllUsers(): ArrayList<UserModel> {
        val userList = ArrayList<UserModel>()
        val db = this.readableDatabase
        val query = "SELECT * FROM usuarios"
        val cursor = db.rawQuery(query, null)

        if (cursor.moveToFirst()) {
            do {
                val id = cursor.getInt(0)
                val nombre = cursor.getString(1)
                val apellido = cursor.getString(2)
                val userId = cursor.getString(3)
                val correo = cursor.getString(4)
                val recCorreo = cursor.getString(5)
                val pass = cursor.getString(6)

                userList.add(UserModel(id, nombre, apellido, userId, correo, recCorreo, pass))
            } while (cursor.moveToNext())
        }

        cursor.close()
        db.close()
        return userList
    }
}


