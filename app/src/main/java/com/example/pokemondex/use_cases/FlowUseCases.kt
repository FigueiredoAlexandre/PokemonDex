package com.example.pokemondex.use_cases

import kotlinx.coroutines.flow.Flow

abstract class FlowUseCases<T> {


    abstract fun performAction(): Flow<T>
}