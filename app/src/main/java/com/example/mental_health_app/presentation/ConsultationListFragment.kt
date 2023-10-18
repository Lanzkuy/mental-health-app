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
import com.example.mental_health_app.presentation.adapter.ConsultantAdapter
import com.example.mental_health_app.utils.Communicator

class ConsultationListFragment : Fragment() {
    private lateinit var binding: FragmentConsultationListBinding
    private lateinit var consultantAdapter: ConsultantAdapter
    private lateinit var communicator: Communicator

    companion object {
        lateinit var consultants: MutableList<Consultant>
    }

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
        communicator = requireActivity() as Communicator

        consultantAdapter.setItemClick(object : ConsultantAdapter.AdapterListener {
            override fun onClick(position: Int) {
                val bundle = Bundle()
                bundle.putInt("POSITION", position)
                communicator.sendData(bundle, ConsultantFragment(), "Consultant")
            }
        })

        binding.rvConsultant.adapter = consultantAdapter
    }

    private fun loadConsultants() {
        consultants = mutableListOf(
            Consultant(
                1,
                R.drawable.profile,
                "Bayu Kusuma M.Psi",
                1,
                120,
                8,
                4.7,
                150000.00,
                resources.getString(R.string.lorem_ipsum),
                1
            ),
            Consultant(
                2,
                R.drawable.img_profile2,
                "Jenny Sue M.Psi",
                1,
                68,
                3,
                4.2,
                80000.00,
                resources.getString(R.string.lorem_ipsum),
                1
            ),
            Consultant(
                3,
                R.drawable.img_profile3,
                "Ahmad Dion M.Psi",
                1,
                80,
                5,
                4.5,
                110000.00,
                resources.getString(R.string.lorem_ipsum),
                2
            )
        )
    }
}