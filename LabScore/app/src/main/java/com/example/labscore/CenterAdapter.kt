package com.example.labscore

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.labscore.models.CenterModel

class CenterAdapter(private val centerList: ArrayList<CenterModel>) :
    RecyclerView.Adapter<CenterAdapter.CenterViewHolder>() {

    // ViewHolder = la "tarjeta" visual
    class CenterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvNombre: TextView = itemView.findViewById(R.id.tvNombreCentro)
        val tvDireccion: TextView = itemView.findViewById(R.id.tvDireccion)
        val tvPrecio: TextView = itemView.findViewById(R.id.tvPrecio)
        val btnDetalles: Button = itemView.findViewById(R.id.btnDetalles)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CenterViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_centro, parent, false)
        return CenterViewHolder(view)
    }

    override fun onBindViewHolder(holder: CenterViewHolder, position: Int) {
        val center = centerList[position]
        holder.tvNombre.text = center.nombre
        holder.tvDireccion.text = center.direccion
        holder.tvPrecio.text = "Precio promedio: ${center.precioPromedio}"

        holder.btnDetalles.setOnClickListener {
            android.widget.Toast.makeText(
                holder.itemView.context,
                "Detalles de ${center.nombre}",
                android.widget.Toast.LENGTH_SHORT
            ).show()
        }
    }

    override fun getItemCount(): Int = centerList.size
}


