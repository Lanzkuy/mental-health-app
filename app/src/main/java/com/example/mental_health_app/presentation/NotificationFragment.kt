package com.example.mental_health_app.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mental_health_app.R
import com.example.mental_health_app.databinding.FragmentNewPasswordBinding
import com.example.mental_health_app.databinding.FragmentNotificationBinding

class NotificationFragment : Fragment() {
    private lateinit var binding: FragmentNotificationBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNotificationBinding.inflate(layoutInflater)
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
    }
}