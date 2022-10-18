package com.example.pokeapi.data.remote.apiservices

import com.example.pokeapi.models.PokemonModel
import com.example.pokeapi.models.PokemonResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface PokeApi {

    @GET("pokemon")
    suspend fun fetchPokemonName(): PokemonResponse<PokemonModel>
}