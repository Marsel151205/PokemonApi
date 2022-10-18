package com.example.pokeapi.data.repositories

import androidx.lifecycle.liveData
import com.example.pokeapi.common.Resource
import com.example.pokeapi.data.remote.apiservices.PokeApi
import okio.IOException
import javax.inject.Inject

class PokemonRepository @Inject constructor(private val pokeApi: PokeApi) {

    fun fetchPokemonName() = liveData {
        emit(Resource.Loading())
        try {
            emit(Resource.Success(pokeApi.fetchPokemonName()))
        } catch (ioException: IOException) {
            emit(Resource.Error(ioException.localizedMessage ?: "error", data = null))
        }
    }
}