package com.example.mental_health_app.presentation

import android.content.res.Resources
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AlphaAnimation
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mental_health_app.R
import com.example.mental_health_app.databinding.BottomSheetHomeBinding
import com.example.mental_health_app.databinding.FragmentHomeBinding
import com.example.mental_health_app.model.Article
import com.example.mental_health_app.presentation.adapter.ArticleAdapter
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var bindingBottomSheet: BottomSheetHomeBinding
    private lateinit var articleAdapter: ArticleAdapter
    private lateinit var articles: MutableList<Article>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bottomNavigationView: BottomNavigationView = requireActivity().findViewById(R.id.navigation)
        bottomNavigationView.visibility = View.VISIBLE

        initializeComponent()
    }

    private fun initializeComponent() {
        binding.ivSearch.setOnClickListener {
            requireActivity().supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragmentContainer, SearchFragment(), "Notification")
                .addToBackStack("Notification")
                .commit()
        }

        binding.ivNotification.setOnClickListener {
            requireActivity().supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragmentContainer, NotificationFragment(), "Notification")
                .addToBackStack("Notification")
                .commit()
        }

        binding.cardConsultation.setOnClickListener {
            requireActivity().supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragmentContainer, ConsultationFragment(), "Notification")
                .addToBackStack("Consultation")
                .commit()
        }

        binding.cardOther.setOnClickListener {
            showBottomSheet()
        }

        val images = ArrayList<Int>()
        images.add(R.drawable.img_banner_1)
        images.add(R.drawable.img_banner_4)
        images.add(R.drawable.img_banner_3)
        binding.ivCarousel.animateCarousel(
            images,
            1800L,
            1500L,
            1000
        )

        loadArticle()
        binding.rvArticle.layoutManager = LinearLayoutManager(requireActivity())
        articleAdapter = ArticleAdapter(articles)
        binding.rvArticle.adapter = articleAdapter
    }

    private fun showBottomSheet() {
        bindingBottomSheet = BottomSheetHomeBinding.inflate(layoutInflater)
        val bottomSheet = BottomSheetDialog(requireActivity())
        bottomSheet.setContentView(bindingBottomSheet.root)

        val bottomSheetBehavior = BottomSheetBehavior.from(bindingBottomSheet.bottomSheetHome.parent as View)
        bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED

        val layout = bindingBottomSheet.bottomSheetHome
        layout.minimumHeight = Resources.getSystem().displayMetrics.heightPixels

        bindingBottomSheet.cardConsultation.setOnClickListener {
            requireActivity().supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragmentContainer, ConsultationFragment(), "Notification")
                .addToBackStack("Consultation")
                .commit()
            bottomSheet.hide()
        }

        bottomSheet.show()
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

    private fun loadArticle() {
        articles = mutableListOf(
            Article(
                1,
                R.drawable.img_thumbnail_1,
                "Mengatasi Kecemasan Sosial",
                "Kecemasan sosial adalah kondisi yang dapat berdampak negatif pada " +
                        "kesejahteraan mental individu. Hal ini seringkali dapat mengganggu " +
                        "hubungan sosial, pekerjaan, dan kehidupan sehari-hari."
            ),
            Article(
                2,
                R.drawable.img_thumbnail_2,
                "Pentingnya Self-Care dan Menjaga Kesehatan Mental",
                "Merawat diri sendiri adalah kunci untuk menjaga kesehatan mental yang baik."
            ),
            Article(
                3,
                R.drawable.img_thumbnail_3,
                "Depresi di Kalangan Remaja",
                "Depresi pada remaja semakin umum. "
            ),
            Article(
                4,
                R.drawable.img_thumbnail_4,
                "Mengapa Kucing dan Anjing Bisa Meningkatkan Kesehatan Mental Anda",
                "Kehadiran kucing dan anjing dalam kehidupan kita dapat memberikan manfaat " +
                        "luar biasa bagi kesehatan mental. "
            )
        )
    }
}