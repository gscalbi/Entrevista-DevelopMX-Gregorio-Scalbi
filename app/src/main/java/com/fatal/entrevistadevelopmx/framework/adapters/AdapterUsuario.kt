package com.fatal.entrevistadevelopmx.framework.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fatal.entrevistadevelopmx.R
import com.fatal.entrevistadevelopmx.data.Result
import com.fatal.entrevistadevelopmx.framework.viewHolders.ViewHolderUsuarios

class AdapterUsuario (var listaUsuarios : List<Result>) : RecyclerView.Adapter<ViewHolderUsuarios>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderUsuarios {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolderUsuarios(layoutInflater.inflate(R.layout.item_usuario,parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolderUsuarios, position: Int) {
        val user = listaUsuarios[position]
        holder.bind(user)
    }

    override fun getItemCount(): Int = listaUsuarios.size
}