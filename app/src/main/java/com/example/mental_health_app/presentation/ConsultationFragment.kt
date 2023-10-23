package com.example.mental_health_app.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.mental_health_app.R
import com.example.mental_health_app.databinding.FragmentConsultationBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class ConsultationFragment : Fragment() {
    private lateinit var binding: FragmentConsultationBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentConsultationBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bottomNavigationView: BottomNavigationView = requireActivity().findViewById(R.id.navigation)
        bottomNavigationView.visibility = View.GONE

        initializeComponent()
    }

    private fun initializeComponent() {
        binding.btnBack.setOnClickListener {
            requireActivity().supportFragmentManager
                .popBackStack()
        }

        binding.btnPsikolog.setOnClickListener {
            requireActivity().supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragmentContainer, ConsultationListFragment(), "Psikolog")
                .addToBackStack("Psikolog")
                .commit()
        }

        binding.btnPsikiater.setOnClickListener {
            requireActivity().supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragmentContainer, ConsultationListFragment(), "Psikiater")
                .addToBackStack("Psikiater")
                .commit()
        }
    }
}