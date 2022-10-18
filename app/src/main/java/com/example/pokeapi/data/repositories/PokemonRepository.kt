package com.example.pokeapi.data.repositories

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.pokeapi.data.remote.apiservices.PokeApi
import com.example.pokeapi.models.PokemonModel
import com.example.pokeapi.models.PokemonResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class PokemonRepository @Inject constructor(private val pokeApi: PokeApi) {

    fun fetchPokemonName(offset: Int, limit: Int): MutableLiveData<List<PokemonModel>> {
        val pokemonModel = MutableLiveData<List<PokemonModel>>()

        pokeApi.fetchPokemonName(offset, limit).enqueue(object : Callback<PokemonResponse> {
            override fun onResponse(
                call: Call<PokemonResponse>,
                response: Response<PokemonResponse>
            ) {
                response.body()?.let {
                    pokemonModel.postValue(it.result)
                }
            }

            override fun onFailure(call: Call<PokemonResponse>, t: Throwable) {
                Log.e("pokemon", t.message.toString())
            }

        })
        return pokemonModel
    }
}