package com.example.mental_health_app.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mental_health_app.R
import com.example.mental_health_app.databinding.FragmentEditProfileBinding
import com.example.mental_health_app.databinding.FragmentProfileBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class EditProfileFragment : Fragment() {
    private lateinit var binding: FragmentEditProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentEditProfileBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initializeComponent()
    }

    private fun initializeComponent() {
        binding.btnBack.setOnClickListener {
            requireActivity().supportFragmentManager
                .popBackStack()
        }

        binding.btnSubmit.setOnClickListener {
            requireActivity().supportFragmentManager
                .popBackStack()
        }
    }
}