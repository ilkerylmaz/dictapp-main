package com.example.dictionary.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dictionary.R
import com.example.dictionary.adapters.GamesAdapter
import com.example.dictionary.databinding.FragmentGamesBinding
import com.example.dictionary.models.Game

class GamesFragment : Fragment() {
    private var _binding: FragmentGamesBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGamesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupGamesRecyclerView()
    }

    private fun setupGamesRecyclerView() {
        val games = listOf(
            Game(
                1,
                "Kelime Eşleştirme",
                "Kelimeleri anlamlarıyla eşleştir",
                R.drawable.ic_match
            ),
            Game(
                2,
                "Kelime Bulmaca",
                "Karışık harflerden kelime bul",
                R.drawable.ic_puzzle
            ),
            Game(
                3,
                "Hafıza Kartları",
                "Kelimeleri hafızanda tut",
                R.drawable.ic_memory
            )
        )

        val gamesAdapter = GamesAdapter(games) { game ->
            when (game.id) {
                1 -> findNavController().navigate(R.id.action_nav_games_to_wordMatchingFragment)
                2 -> findNavController().navigate(R.id.action_nav_games_to_wordPuzzleFragment)
                3 -> findNavController().navigate(R.id.action_nav_games_to_memoryGameFragment)
            }
        }

        binding.gamesRecyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = gamesAdapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
} 