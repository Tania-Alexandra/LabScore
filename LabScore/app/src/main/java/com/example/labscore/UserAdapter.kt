package com.example.labscore.models

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.labscore.R

class UserAdapter(private val userList: ArrayList<UserModel>) :
    RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    // Esta clase interna representa una "tarjeta" de usuario (usa item_usuario.xml)
    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvNombre: TextView = itemView.findViewById(R.id.tvNombre)
        val tvCorreo: TextView = itemView.findViewById(R.id.tvCorreo)
    }

    // Crea cada tarjeta usando el layout item_usuario.xml
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_usuario, parent, false)
        return UserViewHolder(view)
    }

    // Rellena cada tarjeta con los datos del usuario
    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = userList[position]
        holder.tvNombre.text = "${user.nombre} ${user.apellido}"
        holder.tvCorreo.text = user.correo
    }

    // Cuántos usuarios hay
    override fun getItemCount(): Int = userList.size
}