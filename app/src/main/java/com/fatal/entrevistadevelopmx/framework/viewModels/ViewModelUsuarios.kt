package com.fatal.entrevistadevelopmx.framework.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fatal.entrevistadevelopmx.data.ResponseAPI
import com.fatal.entrevistadevelopmx.data.RetrofitClient
import kotlinx.coroutines.launch
import retrofit2.http.Query
import kotlin.coroutines.CoroutineContext

class ViewModelUsuarios : ViewModel() {
    private val _users = MutableLiveData<ResponseAPI>()
    val users: LiveData<ResponseAPI> = _users

}