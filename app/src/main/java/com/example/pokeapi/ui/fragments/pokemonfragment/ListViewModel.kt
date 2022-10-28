package com.example.pokeapi.ui.fragments.pokemonfragment

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.pokeapi.base.BaseViewModel
import com.example.pokeapi.common.Resource
import com.example.pokeapi.data.remote.apiservices.PokeApi
import com.example.pokeapi.data.repositories.PokemonRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(private val repository: PokemonRepository) :
    BaseViewModel() {

    fun fetchPokemonName() = repository.fetchPokemonName()
}
