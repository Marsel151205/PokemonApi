package com.example.pokeapi.data.repositories

import androidx.lifecycle.liveData
import com.example.pokeapi.base.BaseRepository
import com.example.pokeapi.common.Resource
import com.example.pokeapi.data.remote.apiservices.PokeApi
import okio.IOException
import javax.inject.Inject

class PokemonRepository @Inject constructor(private val pokeApi: PokeApi): BaseRepository() {

    fun fetchPokemonName() = doRequest {
        pokeApi.fetchPokemonName()
    }
}