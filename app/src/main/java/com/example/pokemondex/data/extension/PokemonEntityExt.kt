package com.example.pokemondex.data.extension

import com.example.pokemondex.data.PokemonModel
import com.example.pokemondex.framework.remote.entity.PokemonResponseEntity


fun PokemonResponseEntity.toPokemonModel(): PokemonModel{
    return PokemonModel(
        id = this.id,
        name = this.name,
        height = this.height,
        weight = this.weight,
        pokeImageUrl = this.sprites.front_default
    )
}