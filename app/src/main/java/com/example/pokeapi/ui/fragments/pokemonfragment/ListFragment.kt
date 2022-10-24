package com.example.pokeapi.ui.fragments.pokemonfragment

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.extensions.radin
import com.example.pokeapi.R
import com.example.pokeapi.base.BaseFragment
import com.example.pokeapi.common.Resource
import com.example.pokeapi.databinding.FragmentListBinding
import com.example.pokeapi.models.PokemonModel
import com.example.pokeapi.models.PokemonResponse
import com.example.pokeapi.ui.adapters.PokemonAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListFragment : BaseFragment<FragmentListBinding, ListViewModel>(R.layout.fragment_list) {

    override val binding by viewBinding(FragmentListBinding::bind)
    override val viewModel: ListViewModel by viewModels()
    private val list = mutableListOf<PokemonModel>()
    private val adapter = PokemonAdapter()

    override fun initialize() {
        setupRecyclerView()
    }


    override fun setupSubscribes() {
        subscribesPokemon()
    }

    private fun setupRecyclerView() {
        binding.rvListPokemon.adapter = adapter
    }

    private fun subscribesPokemon() {
        viewModel.fetchPokemonName().observe(viewLifecycleOwner) {
            viewModel.radin() {
                adapter.submitList(it.data?.result)
            }
        }
    }


}

