package com.example.mental_health_app.presentation

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.mental_health_app.databinding.FragmentConsultantBinding
import com.example.mental_health_app.presentation.ConsultationListFragment.Companion.consultants

class ConsultantFragment : Fragment() {
    private lateinit var binding: FragmentConsultantBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentConsultantBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initializeComponent()
    }

    @SuppressLint("SetTextI18n")
    private fun initializeComponent() {
        binding.btnBack.setOnClickListener {
            requireActivity().supportFragmentManager
                .popBackStack()
        }

        val bundle = arguments
        if (bundle != null) {
            val position = bundle.getInt("POSITION", -1)
            if (position > -1) {
                val data = consultants[position]
                binding.ivProfilePicture.setImageResource(data.profilePicture)
                binding.tvName.text = data.name
                binding.tvRole.text = if (data.role == 1) "Psikolog" else "Psikiater"
                binding.tvPatient.text = data.totalPatient.toString()
                binding.tvExperience.text = "${data.experience} years"
                binding.tvRating.text = data.rating.toString()
                binding.tvPriceValue.text = "Rp. ${data.consultPrice}"
                binding.tvBiographyValue.text = data.biography
            }
        }
    }
}