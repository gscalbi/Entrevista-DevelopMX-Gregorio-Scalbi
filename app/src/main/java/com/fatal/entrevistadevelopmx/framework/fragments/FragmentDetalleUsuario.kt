package com.fatal.entrevistadevelopmx.framework.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
        binding.apply {
            Picasso.get().load(args.foto.large)
                .into(civFoto)

            val direccionText =
                "${args.direccion.street.name} " +
                        "${args.direccion.street.number}, " +
                        "${args.direccion.city}, " +
                        args.direccion.state
            tvDireccion.text = direccionText
            tvTelefono.text = args.telefono
        }
    }
}