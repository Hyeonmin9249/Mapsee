package com.example.mapsee.ui.mycloset

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.mapsee.databinding.FragmentMyclosetBinding

class MyclosetFragment : Fragment() {

    private var _binding: FragmentMyclosetBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val myclosetViewModel =
            ViewModelProvider(this).get(MyclosetViewModel::class.java)

        _binding = FragmentMyclosetBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textMycloset
        myclosetViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}