package com.fatal.entrevistadevelopmx.framework.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fatal.entrevistadevelopmx.R
import com.fatal.entrevistadevelopmx.databinding.FragmentDetalleUsuarioBinding


class FragmentDetalleUsuario : Fragment() {
    private lateinit var binding: FragmentDetalleUsuarioBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetalleUsuarioBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}