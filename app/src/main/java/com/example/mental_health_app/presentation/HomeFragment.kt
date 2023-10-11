package com.example.mental_health_app.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AlphaAnimation
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.example.mental_health_app.R
import com.example.mental_health_app.databinding.FragmentHomeBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val images = ArrayList<Int>()
        images.add(R.drawable.img_banner_1)
        images.add(R.drawable.img_banner_2)
        images.add(R.drawable.img_banner_3)
        binding.ivCarousel.animateCarousel(
            images,
            2000L,
            1500L,
            1000
        )
    }

    private fun ImageView.animateCarousel(
        images: ArrayList<Int>,
        fadeAfter: Long = 1500L,
        difference: Long = 1500L,
        fadeOut: Long = 500
    ) {
        CoroutineScope(Dispatchers.Main).launch {
            images.forEach {
                setImageResource(it)
                fadeInView(duration = fadeAfter)
                delay(fadeAfter + difference)
                fadeInView(from = 1f, to = 0f, duration = fadeOut)
                delay(fadeOut)
            }
            animateCarousel(images, fadeAfter, difference, fadeOut)
        }
    }

    private fun View.fadeInView(
        from: Float = 0f,
        to: Float = 1f,
        duration: Long = 1000
    ) {
        val animation = AlphaAnimation(from, to)
        animation.duration = duration
        setAnimation(animation)
    }
}