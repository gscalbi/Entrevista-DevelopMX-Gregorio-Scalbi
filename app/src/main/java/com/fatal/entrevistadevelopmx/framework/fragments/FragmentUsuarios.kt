package com.fatal.entrevistadevelopmx.framework.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.size
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.fatal.entrevistadevelopmx.data.APIService
import com.fatal.entrevistadevelopmx.data.Result
import com.fatal.entrevistadevelopmx.databinding.FragmentUsuariosBinding
import com.fatal.entrevistadevelopmx.framework.adapters.AdapterUsuario
import com.fatal.entrevistadevelopmx.framework.viewModels.ViewModelUsuarios
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class FragmentUsuarios : Fragment() {
    private lateinit var binding: FragmentUsuariosBinding
    private val viewModel by viewModels<ViewModelUsuarios>()
    private val usuarios = mutableListOf<Result>()
    private lateinit var adapter: AdapterUsuario

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUsuariosBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //inicializa el RecycleView
        recyclerLoad()
        //configura viewModel
        ViewModelSet()
        //setea los listeners de los botones
        setBotones()
    }

    private fun setBotones() {
        binding.btnGeneroFemenino.setOnClickListener {
            viewModel.searchByName("&gender=female")
        }
        binding.btnGeneroMasculino.setOnClickListener {
            viewModel.searchByName("&gender=male")
        }
        binding.btnReset.setOnClickListener {
            viewModel.searchByName("")
        }
    }

    private fun ViewModelSet() {
        viewModel.usuarios.observe(viewLifecycleOwner) {
            adapter = AdapterUsuario(it)
            binding.rvUsers.adapter = adapter
            adapter.notifyDataSetChanged()
            binding.rvUsers.smoothScrollToPosition(0)
        }
    }

    private fun recyclerLoad() {
        adapter = AdapterUsuario(usuarios)
        binding.rvUsers.layoutManager = LinearLayoutManager(binding.root.context)
        binding.rvUsers.adapter = AdapterUsuario(usuarios)
    }

}

