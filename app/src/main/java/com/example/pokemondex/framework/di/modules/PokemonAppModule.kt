package com.example.pokemondex.framework.di.modules

import com.example.pokemondex.data.PokemonDataSource
import com.example.pokemondex.data.PokemonDataSourceImp
import com.example.pokemondex.data.PokemonRepository
import com.example.pokemondex.data.PokemonRepositoryImp
import com.example.pokemondex.framework.di.component.SingletonComponent
import com.example.pokemondex.framework.remote.PokemonApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
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
}