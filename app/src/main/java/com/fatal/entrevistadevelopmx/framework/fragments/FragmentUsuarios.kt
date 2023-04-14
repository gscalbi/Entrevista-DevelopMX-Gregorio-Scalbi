package com.fatal.entrevistadevelopmx.framework.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
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
    private lateinit var adapter : AdapterUsuario

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUsuariosBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerLoad()




        binding.btnGeneroFemenino.setOnClickListener {
            searchByName("&gender=female" )

        }
        binding.btnGeneroMasculino.setOnClickListener {
            searchByName("&gender=male" )

        }
        binding.btnReset.setOnClickListener {
            searchByName("")

        }
    }

    private fun recyclerLoad(){
        adapter = AdapterUsuario(usuarios)
        binding.rvUsers.layoutManager =LinearLayoutManager(binding.root.context)
        binding.rvUsers.adapter = AdapterUsuario(usuarios)

    }

    private fun getRetrofit(): Retrofit {
        var retro =Retrofit.Builder()
            .baseUrl("https://randomuser.me/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retro
    }
    private fun searchByName(query : String){
        CoroutineScope(Dispatchers.IO).launch {
                val call = getRetrofit().create(APIService::class.java).getUsers("?results=50$query")
                val body = call.body()
                activity?.runOnUiThread {
                    if (call.isSuccessful){
                       val users = body?.results ?: emptyList()
                        usuarios.clear()
                       usuarios.addAll(users)
                        adapter= AdapterUsuario(usuarios)
                        binding.rvUsers.adapter= adapter
                        adapter.notifyDataSetChanged()
                        binding.rvUsers.smoothScrollToPosition(0)
                    }
                }

            }

        }
    }
