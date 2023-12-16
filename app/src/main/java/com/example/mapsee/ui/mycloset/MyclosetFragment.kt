package com.example.mapsee.ui.mycloset

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import com.example.mapsee.databinding.FragmentMyclosetBinding

class MyclosetFragment : Fragment() {

    private var _binding: FragmentMyclosetBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMyclosetBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Example item counts
        val outerwearCount = 5
        val topsCount = 15
        val bottomsCount = 10
        val accessoriesCount = 7
        val totalItems = outerwearCount + topsCount + bottomsCount + accessoriesCount

        // Update progress bars
        updateProgressBar(binding.progressBarOuterwear, calculatePercentage(outerwearCount, totalItems))
        updateProgressBar(binding.progressBarTops, calculatePercentage(topsCount, totalItems))
        updateProgressBar(binding.progressBarBottoms, calculatePercentage(bottomsCount, totalItems))
        updateProgressBar(binding.progressBarAccessories, calculatePercentage(accessoriesCount, totalItems))
    }

    private fun calculatePercentage(itemCount: Int, totalItems: Int): Int {
        return if (totalItems > 0) (itemCount * 100) / totalItems else 0
    }

    private fun updateProgressBar(progressBar: ProgressBar, percentage: Int) {
        progressBar.progress = percentage
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
