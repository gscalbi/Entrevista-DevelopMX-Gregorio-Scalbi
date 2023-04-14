package com.fatal.entrevistadevelopmx.framework.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.navArgs
import com.fatal.entrevistadevelopmx.R
import com.fatal.entrevistadevelopmx.databinding.FragmentDetalleUsuarioBinding
import com.squareup.picasso.Picasso


class FragmentDetalleUsuario : Fragment() {
    private lateinit var binding: FragmentDetalleUsuarioBinding
    private val args: FragmentDetalleUsuarioArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetalleUsuarioBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.actionBar?.setDisplayHomeAsUpEnabled(true)
        try{
            loadData(view)
        }catch (e:Exception){
            Toast.makeText(view.context,e.message,Toast.LENGTH_SHORT).show()
        }

    }

    private fun loadData(view: View) {
        binding.apply {
            Picasso.get().load(args.foto.large)
                .placeholder(R.mipmap.ic_person_round)
                .error(R.mipmap.ic_person_round)
                .into(civFoto)
            val direccionText =
                "${args.direccion.street.name} " +
                        "${args.direccion.street.number},\n" +
                        "${args.direccion.city}, " +
                        args.direccion.country
            tvDireccion.text = direccionText
            tvTelefono.text = args.telefono

        }
    }
}