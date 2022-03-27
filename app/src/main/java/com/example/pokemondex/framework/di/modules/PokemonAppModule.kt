package com.example.pokemondex.framework.di.modules

import com.example.pokemondex.data.*
import com.example.pokemondex.data.receive_state.ReceiveState
import com.example.pokemondex.framework.remote.PokemonApi
import com.example.pokemondex.use_cases.FlowUseCases
import com.example.pokemondex.use_cases.GetPokemonsUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(dagger.hilt.components.SingletonComponent::class)
object PokemonAppModule {


    @Provides
    @Singleton
    fun providesPokemonApi(): PokemonApi{
        return Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PokemonApi::class.java)

    }

    @Provides
    @Singleton
    fun providesPokemonDataSource(api: PokemonApi): PokemonDataSource{
        return PokemonDataSourceImp(api)
    }

    @Provides
    @Singleton
    fun providesPokemonRepository(dataSource: PokemonDataSource): PokemonRepository{
        return PokemonRepositoryImp(dataSource)
    }

    @Provides
    @Singleton
    fun providesGetPokemonsUseCases(repository: PokemonRepository): FlowUseCases<ReceiveState<List<PokemonModel>>>{
        return GetPokemonsUseCases(repository)
    }
}