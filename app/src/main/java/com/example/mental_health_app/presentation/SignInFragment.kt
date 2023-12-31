package com.example.mental_health_app.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.mental_health_app.R
import com.example.mental_health_app.databinding.FragmentSignInBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class SignInFragment : Fragment() {
    private lateinit var binding: FragmentSignInBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSignInBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bottomNavigationView: BottomNavigationView = requireActivity().findViewById(R.id.navigation)
        bottomNavigationView.visibility = View.GONE
        bottomNavigationView.menu.getItem(0).isChecked = true

        initializeComponent()
    }

    private fun initializeComponent() {
        binding.tvForgotPassword.setOnClickListener {
            requireActivity().supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragmentContainer, ForgotPasswordFragment(), null)
                .commit()
        }

        binding.btnSignIn.setOnClickListener {
            requireActivity().supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragmentContainer, HomeFragment(), null)
                .commit()
        }

        binding.tvSignUp.setOnClickListener {
            requireActivity().supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragmentContainer, SignUpFragment(), null)
                .commit()
        }
    }
}