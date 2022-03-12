package com.example.pokemondex.data

interface PokemonDataSource {

    fun getPokemons(): List<PokemonModel>

}