package com.example.pokemondex.framework.remote

import com.example.pokemondex.framework.remote.entity.PokemonResponseEntity
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonApi {

    @GET("pokemon/{id}")
    fun getPokemons(@Path("id") id: Int): PokemonResponseEntity
}