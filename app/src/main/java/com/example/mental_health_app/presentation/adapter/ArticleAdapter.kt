package com.example.mental_health_app.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mental_health_app.databinding.ItemArticleBinding
import com.example.mental_health_app.model.Article

class ArticleAdapter(
    private val articles: List<Article>
) : RecyclerView.Adapter<ArticleAdapter.ViewHolder>(
) {
    class ViewHolder(val binding: ItemArticleBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemArticleBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(articles[position]) {
            holder.binding.ivThumbnail.setImageResource(thumbnail)
            holder.binding.tvTitle.text = title
            holder.binding.tvContent.text = content
        }
    }

    override fun getItemCount(): Int = articles.size
}