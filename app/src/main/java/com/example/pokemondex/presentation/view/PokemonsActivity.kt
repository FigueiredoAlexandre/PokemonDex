package com.example.pokemondex.presentation.view

import android.os.Bundle
import android.os.PersistableBundle
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.pokemondex.R
import com.example.pokemondex.databinding.ActivityPokemonsBinding
import com.example.pokemondex.presentation.viewmodel.PokemonViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class PokemonsActivity: AppCompatActivity() {

    private lateinit var binding: ActivityPokemonsBinding
    private lateinit var navController: NavController

    val viewModel by viewModels<PokemonViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPokemonsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpNavControllerWithBottomNavigationView()
        setUpToolbar()
        
    }


    private fun setUpNavControllerWithBottomNavigationView() {
        binding.apply {
            val fragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment)
            fragment?.let {
                navController = it.findNavController()
            }
            bottomPokemonNavigation.setupWithNavController(navController)
        }
    }

    private fun setUpToolbar() {
        setSupportActionBar(binding.pokemonToolbar)
        val supportActionBar = supportActionBar
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(false)
            setDisplayShowTitleEnabled(true)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.home -> {
                onBackPressed()
                return true
            }
        }
        return super.onContextItemSelected(item)
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }
}