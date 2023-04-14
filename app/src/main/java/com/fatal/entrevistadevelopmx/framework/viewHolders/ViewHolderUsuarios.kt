package com.fatal.entrevistadevelopmx.framework.viewHolders

import android.content.res.Resources
import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.fatal.entrevistadevelopmx.R
import com.fatal.entrevistadevelopmx.data.Result
import com.fatal.entrevistadevelopmx.databinding.ItemUsuarioBinding
import com.fatal.entrevistadevelopmx.usecases.Navigator

class ViewHolderUsuarios (var view: View) : RecyclerView.ViewHolder(view) {
    private val binding = ItemUsuarioBinding.bind(view)

    fun bind(result: Result){
        binding.tvEmail.text = result.email
        binding.tvGenero.text = result.gender
        val nombre ="${result.name.title} ${result.name.first} ${result.name.last}"
        binding.tvNombre.text = nombre

        binding.cardUsuario.setOnClickListener {
            Navigator(view).onItemSelected(result.picture,result.location,result.phone,result.gender)
        }
    }
}