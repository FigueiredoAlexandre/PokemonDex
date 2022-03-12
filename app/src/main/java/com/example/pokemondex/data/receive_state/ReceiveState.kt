package com.example.pokemondex.data.receive_state

sealed class ReceiveState<T>(val data: T? = null, val message: String? = null) {
    class Success<T>(data: T?) : ReceiveState<T>(data)
    class Error<T>(data: T? = null, message: String?) : ReceiveState<T>(data, message)
    class Loading<T>(data: T? = null): ReceiveState<T>(data)
}