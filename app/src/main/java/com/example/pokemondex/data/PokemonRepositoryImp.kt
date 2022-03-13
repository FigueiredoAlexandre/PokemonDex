package com.example.pokemondex.data

import javax.inject.Inject

class PokemonRepositoryImp @Inject constructor(
    val dataSource: PokemonDataSource
): PokemonRepository {



    override suspend fun getThePokemonsFromDataSource(): List<PokemonModel> {
        TODO("Not yet implemented")
    }


}