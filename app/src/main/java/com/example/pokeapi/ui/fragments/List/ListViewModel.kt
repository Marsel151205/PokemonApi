package com.example.pokeapi.ui.fragments.List

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pokeapi.data.repositories.PokemonRepository
import com.example.pokeapi.models.PokemonModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(private val repository: PokemonRepository) : ViewModel() {

    fun fetchPokemonName(offset: Int, limit: Int): MutableLiveData<List<PokemonModel>> {
        return repository.fetchPokemonName(offset, limit)
    }
}