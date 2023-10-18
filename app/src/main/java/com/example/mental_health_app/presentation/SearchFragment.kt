package com.example.mental_health_app.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.mental_health_app.R
import com.example.mental_health_app.databinding.FragmentChangePasswordBinding
import com.example.mental_health_app.databinding.FragmentSearchBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class SearchFragment : Fragment() {
    private lateinit var binding: FragmentSearchBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSearchBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bottomNavigationView: BottomNavigationView =
            requireActivity().findViewById(R.id.navigation)
        bottomNavigationView.visibility = View.GONE

        initializeComponent()
    }

    private fun initializeComponent() {
        binding.btnBack.setOnClickListener {
            requireActivity().supportFragmentManager
                .popBackStack()
        }
    }
}