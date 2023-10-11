package com.example.mental_health_app.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.mental_health_app.R
import com.example.mental_health_app.databinding.FragmentGetStartedBinding

class GetStartedFragment : Fragment() {
    private lateinit var binding: FragmentGetStartedBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGetStartedBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initializeComponent()
    }

    private fun initializeComponent() {
        binding.btnSignIn.setOnClickListener {
            requireActivity().supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragmentContainer, SignInFragment(), "SignIn")
                .addToBackStack("SignIn")
                .commit()
        }

        binding.btnSignUp.setOnClickListener {
            requireActivity().supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragmentContainer, SignUpFragment(), "SignUp")
                .addToBackStack("SignUp")
                .commit()
        }
    }
}