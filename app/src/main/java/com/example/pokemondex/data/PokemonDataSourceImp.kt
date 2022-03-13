package com.example.pokemondex.data

import com.example.pokemondex.data.extension.toPokemonModel
import com.example.pokemondex.framework.remote.PokemonApi
import javax.inject.Inject

class PokemonDataSourceImp @Inject constructor(
    val api: PokemonApi
): PokemonDataSource {


    override fun getPokemons(idStart: Int, idEnd: Int): List<PokemonModel> {
        var listOfPokemons: MutableList<PokemonModel> = arrayListOf()
        for( index in idStart until idEnd){
            val incomingPokemon = api.getPokemons(index).toPokemonModel()
            listOfPokemons.add(incomingPokemon)
        }
        return listOfPokemons
    }


}