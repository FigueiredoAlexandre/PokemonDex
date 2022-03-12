package com.example.pokemondex.use_cases

import com.example.pokemondex.data.PokemonModel
import com.example.pokemondex.data.receive_state.ReceiveState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetPokemonsUseCases: FlowUseCases<ReceiveState<List<PokemonModel>>>() {


    override fun performAction(queryString: String): Flow<ReceiveState<List<PokemonModel>>> {
        return flow {
            
        }
    }
}