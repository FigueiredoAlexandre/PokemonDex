package com.example.pokemondex.presentation.view

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.example.pokemondex.databinding.ActivityPokemonsBinding

class PokemonsActivity: AppCompatActivity() {

    private lateinit var binding: ActivityPokemonsBinding

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        binding = ActivityPokemonsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        

    }
}