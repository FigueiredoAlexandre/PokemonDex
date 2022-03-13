package com.example.pokemondex.framework.remote

import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonApi {

    @GET("pokemon/{id}")
    suspend fun getPokemons(@Path("id") id: Int)
}