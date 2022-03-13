package com.example.pokemondex.data

interface PokemonDataSource {

    fun getPokemons(idStart: Int, idEnd: Int): List<PokemonModel>

}