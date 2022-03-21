package com.example.pokemondex.data

data class PokemonCategoryModel(
    val hasLottie: Boolean,
    val name: String,
    val resourceSymbol:Int,
    val attackQualities: AttackQualitiesModel,
    val defenseQualities: DefenseQualitiesModel
)