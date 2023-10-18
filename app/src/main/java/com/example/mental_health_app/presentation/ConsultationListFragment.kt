package com.example.mental_health_app.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mental_health_app.R
import com.example.mental_health_app.databinding.FragmentConsultationListBinding
import com.example.mental_health_app.model.Consultant
import com.example.mental_health_app.presentation.adapter.ArticleAdapter
import com.example.mental_health_app.presentation.adapter.ConsultantAdapter

class ConsultationListFragment : Fragment() {
    private lateinit var binding: FragmentConsultationListBinding
    private lateinit var consultantAdapter: ConsultantAdapter
    private lateinit var consultants: MutableList<Consultant>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentConsultationListBinding.inflate(layoutInflater)
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

        loadConsultants()
        binding.rvConsultant.layoutManager = LinearLayoutManager(requireActivity())
        consultantAdapter = ConsultantAdapter(consultants)
        binding.rvConsultant.adapter = consultantAdapter
    }

    private fun loadConsultants() {
        consultants = mutableListOf(
            Consultant(
                1,
                R.drawable.profile,
                "Jenny Sue M.Psi",
                1,
                120,
                8,
                4.7,
                120000.00,
                resources.getString(R.string.lorem_ipsum),
                1
            )
        )
    }
}