package com.example.pokemondex.framework.remote.entity

import com.google.gson.annotations.SerializedName

data class SpritesEntity(
    @SerializedName("front_default")
    val front_default: String
)