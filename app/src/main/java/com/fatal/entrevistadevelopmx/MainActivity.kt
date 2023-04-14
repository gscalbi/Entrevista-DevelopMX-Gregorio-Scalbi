package com.fatal.entrevistadevelopmx

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import com.fatal.entrevistadevelopmx.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setToolbar()
        //cambiar color de barra de notificaciones
        var window = window
        window.statusBarColor = ContextCompat.getColor(this,R.color.black)

    }

    private fun setToolbar() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        navController = navHostFragment.findNavController()
        appBarConfiguration = AppBarConfiguration(
            setOf(R.id.fragmentUsuarios, R.id.fragmentDetalleUsuario)
        )
        setSupportActionBar(binding.tbPrincipal)
        setupActionBarWithNavController(navController, appBarConfiguration)
        val actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (navController.currentDestination?.id) {
                R.id.fragmentUsuarios -> actionBar?.setDisplayHomeAsUpEnabled(false)
                R.id.fragmentDetalleUsuario -> actionBar?.setDisplayHomeAsUpEnabled(true)
            }
        }
        binding.tbPrincipal.setNavigationOnClickListener { view ->
            navController.navigateUp()
        }
    }
}