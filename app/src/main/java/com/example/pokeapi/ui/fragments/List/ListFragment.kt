package com.example.pokeapi.ui.fragments.List

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.pokeapi.R
import com.example.pokeapi.databinding.FragmentListBinding
import com.example.pokeapi.models.PokemonModel
import com.example.pokeapi.ui.adapters.PokemonListAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListFragment : Fragment(R.layout.fragment_list) {

    private val binding by viewBinding(FragmentListBinding::bind)
    private val viewModel: ListViewModel by viewModels()
    private val list = mutableListOf<PokemonModel>()
    private val adapter = PokemonListAdapter(list)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupSubscribed()
    }

    private fun setupSubscribed() {
       viewModel.fetchPokemonName(0, 20).observe(viewLifecycleOwner) {
           list.addAll(it)
           binding.rvListPokemon.adapter = adapter
       }
    }
}

