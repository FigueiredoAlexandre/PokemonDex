package com.example.pokemondex.presentation.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pokemondex.databinding.LayoutEletricCategoryCardBinding

class PokemonCategoryAdapter: RecyclerView.Adapter<PokemonCategoryAdapter.PokemonCategoryViewHolder>(){


    inner class PokemonCategoryViewHolder(val binding: LayoutEletricCategoryCardBinding): RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonCategoryViewHolder {
        return PokemonCategoryViewHolder(LayoutEletricCategoryCardBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: PokemonCategoryViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}