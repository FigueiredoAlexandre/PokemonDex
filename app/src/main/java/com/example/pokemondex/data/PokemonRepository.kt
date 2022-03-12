package com.example.pokemondex.data

interface PokemonRepository {

    suspend fun getThePokemonsFromDataSource(): List<PokemonModel>
}