package com.example.pokemondex.presentation.viewmodel

import android.graphics.pdf.PdfDocument
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokemondex.data.PokemonModel
import com.example.pokemondex.data.receive_state.ReceiveState
import com.example.pokemondex.use_cases.FlowUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class PokemonViewModel @Inject constructor(
    val useCases: FlowUseCases<ReceiveState<List<PokemonModel>>>
): ViewModel() {

    sealed class PageState{
        object Idle: PageState()
        data class  Error(val errorMessage: String?): PageState()
        object Loading: PageState()
        data class Success(val listOfPokemons: List<PokemonModel>?): PageState()
    }

    private var _pageState = MutableLiveData<PageState>(PageState.Idle)
    var pageState: LiveData<PageState> = _pageState


    fun getPokemons(query: String, start: Int, end: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            useCases.performAction(query, start, end)
                .collect { receivedState ->
                    when (receivedState) {
                        is ReceiveState.Error -> {
                            _pageState.postValue(PageState.Error(receivedState.message))
                        }
                        is ReceiveState.Loading -> {
                            _pageState.postValue(PageState.Loading)
                        }
                        is ReceiveState.Success -> {
                            _pageState.postValue(PageState.Success(receivedState.data))
                        }

                    }

                }
        }
    }
}