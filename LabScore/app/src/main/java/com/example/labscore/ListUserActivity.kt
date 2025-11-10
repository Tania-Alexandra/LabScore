package com.example.labscore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.content.Intent
import android.widget.Button
import com.example.labscore.models.SQLiteHelper
import com.example.labscore.models.UserAdapter

class ListUserActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_user)

                val recycler = findViewById<RecyclerView>(R.id.recyclerUsuarios)
                val btnAgregar = findViewById<Button>(R.id.btnAgregar)

                val dbHelper = SQLiteHelper(this)
                val userList = dbHelper.getAllUsers()

                recycler.layoutManager = LinearLayoutManager(this)
                recycler.adapter =
                    UserAdapter(userList)

                btnAgregar.setOnClickListener {
                    val intent = Intent(this, AddUserActivity::class.java)
                    startActivity(intent)
                }
    }
}