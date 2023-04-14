package com.fatal.entrevistadevelopmx.framework.viewHolders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.fatal.entrevistadevelopmx.data.Result
import com.fatal.entrevistadevelopmx.databinding.ItemUsuarioBinding

class ViewHolderUsuarios (view: View) : RecyclerView.ViewHolder(view) {
    private val binding = ItemUsuarioBinding.bind(view)

    fun bind(result: Result){
        binding.tvEmail.text = result.email
        binding.tvGenero.text = result.gender
        binding.tvNombre.text = "${result.name.title} ${result.name.first} ${result.name.last}"
        binding.cardUsuario.setOnClickListener {

        }
    }
}