package com.fatal.entrevistadevelopmx.framework.viewModels

import android.content.Context
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fatal.entrevistadevelopmx.data.APIService
import com.fatal.entrevistadevelopmx.data.ResponseAPI
import com.fatal.entrevistadevelopmx.data.Result
import com.fatal.entrevistadevelopmx.data.RetrofitClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Query
import kotlin.coroutines.CoroutineContext

class ViewModelUsuarios : ViewModel() {
    private val _usuarios = MutableLiveData<List<Result>>()
    val usuarios: LiveData<List<Result>> = _usuarios

    //construye una instancia de un cliente HTTP que se comunica con un servicio web
    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://randomuser.me/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    //realiza una llamada asíncrona al servicio web y recupera una lista de usuarios
    fun searchByName(query : String) {
        CoroutineScope(Dispatchers.IO).launch {
            val call = getRetrofit().create(APIService::class.java).getUsers("?results=50$query")
            val body = call.body()
            if (call.isSuccessful) {
                val users = body?.results ?: emptyList()
                _usuarios.postValue(users)
            }
        }
    }
}