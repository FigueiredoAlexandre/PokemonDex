package com.example.pokemondex.framework.remote.entity

import com.google.gson.annotations.SerializedName


data class PokemonResponseEntity(
       @SerializedName("id")
       val id: Int,
       @SerializedName("name")
       val name: String,
       @SerializedName("height")
       val height: Int,
       @SerializedName("weight")
       val weight: Int,
       @SerializedName("sprites")
       val sprites: SpritesEntity
)