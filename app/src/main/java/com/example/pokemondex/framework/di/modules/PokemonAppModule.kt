package com.example.pokemondex.framework.di.modules

import com.example.pokemondex.data.PokemonDataSource
import com.example.pokemondex.data.PokemonRepository
import com.example.pokemondex.data.PokemonRepositoryImp
import com.example.pokemondex.framework.di.component.SingletonComponent
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object PokemonAppModule {

   

    @Provides
    @Singleton
    fun providesPokemonRepository(dataSource: PokemonDataSource): PokemonRepository{
        return PokemonRepositoryImp(dataSource)
    }
}