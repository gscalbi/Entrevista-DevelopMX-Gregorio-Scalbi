package com.fatal.entrevistadevelopmx.usecases

import android.view.View
import androidx.navigation.findNavController
import com.fatal.entrevistadevelopmx.data.Location
import com.fatal.entrevistadevelopmx.data.Picture
import com.fatal.entrevistadevelopmx.data.Result
import com.fatal.entrevistadevelopmx.framework.fragments.FragmentUsuariosDirections

class Navigator(var view : View) {
    fun onItemSelected(foto: Picture, direccion: Location, telefono: String, gender: String) {
        val action =
            FragmentUsuariosDirections.actionFragmentUsuariosToFragmentTwo(telefono,gender,direccion,foto)
        view.findNavController().navigate(action)

    }
}