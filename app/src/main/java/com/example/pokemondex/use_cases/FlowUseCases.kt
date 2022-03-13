package com.example.pokemondex.use_cases

import kotlinx.coroutines.flow.Flow

abstract class FlowUseCases<T> {


    abstract suspend  fun performAction(queryString: String, start: Int, end: Int): Flow<T>
}