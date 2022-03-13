package com.example.pokemondex.use_cases

import com.example.pokemondex.data.PokemonModel
import com.example.pokemondex.data.PokemonRepository
import com.example.pokemondex.data.receive_state.ReceiveState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetPokemonsUseCases @Inject constructor(
    val repository: PokemonRepository
): FlowUseCases<ReceiveState<List<PokemonModel>>>() {


    override suspend fun performAction(queryString: String, start: Int, end: Int): Flow<ReceiveState<List<PokemonModel>>> {
        return flow {
            try {
                emit(ReceiveState.Loading())
                val incomingPokemons = repository.getThePokemonsFromDataSource(start, end)
                if (queryString.isNotEmpty()) {
                    val queriedList = incomingPokemons.filter { pokemonModel ->
                        pokemonModel.name.contains(queryString)
                    }
                    emit(ReceiveState.Success(queriedList))
                } else {
                    emit(ReceiveState.Success(incomingPokemons))
                }
            }catch (e: Exception){
               emit(ReceiveState.Error<List<PokemonModel>>(null,"Não foi possível resgatar pokémomns :)"))
            }

        }
    }
}