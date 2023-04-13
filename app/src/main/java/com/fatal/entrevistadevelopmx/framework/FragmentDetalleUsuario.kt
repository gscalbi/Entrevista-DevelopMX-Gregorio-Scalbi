package com.fatal.entrevistadevelopmx.framework

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
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detalle_usuario, container, false)
    }

}