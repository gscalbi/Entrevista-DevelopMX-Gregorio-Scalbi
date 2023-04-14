package com.fatal.entrevistadevelopmx.usecases

import android.view.View
import androidx.navigation.findNavController
import com.fatal.entrevistadevelopmx.data.Picture
import com.fatal.entrevistadevelopmx.framework.fragments.FragmentUsuariosDirections

class Navigator(var view : View) {
    fun onItemSelected(pic: Picture) {
        val action =
            FragmentUsuariosDirections.actionFragmentUsuariosToFragmentTwo()
        view.findNavController().navigate(action)

    }
}