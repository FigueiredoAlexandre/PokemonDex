package com.example.pokemondex.data

interface PokemonRepository {

    suspend fun getThePokemonsFromDataSource(idStart: Int, idEnd: Int): List<PokemonModel>
}