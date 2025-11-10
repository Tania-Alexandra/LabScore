package com.example.labscore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.labscore.models.CenterModel


class CentersActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_centers)

                val recycler = findViewById<RecyclerView>(R.id.recyclerCentros)

                // Lista de centros (por ahora de ejemplo)
                val centers = arrayListOf(
                    CenterModel("Centro Médico San Bernardo", "Av. Portales 1234, San Bernardo", "$25.000"),
                    CenterModel("Clínica Buin Salud", "Camino Padre Hurtado 567, Buin", "$22.000"),
                    CenterModel("Laboratorio Vida", "Av. O’Higgins 890, Paine", "$27.500"),
                    CenterModel("Centro Diagnóstico El Bosque", "Gran Avenida 12000, El Bosque", "$23.000")
                )

                recycler.layoutManager = LinearLayoutManager(this)
                recycler.adapter = CenterAdapter(centers)
    }
}