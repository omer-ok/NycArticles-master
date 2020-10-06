package com.test.nyarticles.ui.Articles.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.test.nyarticles.R
import com.test.nyarticles.data.model.Result
import com.test.nyarticles.databinding.ArticleItemBinding
import com.test.nyarticles.ui.Articles.RecyclerViewClickListener
import com.test.nyarticles.utilz.loadImage

class ArticleAdapter(
    private val articles: List<Result>,
    private val listener: RecyclerViewClickListener
) : RecyclerView.Adapter<ArticleAdapter.ArticlesViewHolder>() {

    override fun getItemCount() = articles.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ArticlesViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.article_item,
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: ArticlesViewHolder, position: Int) {
        holder.recylerviewArticleItemBinding.list = articles[position]
        if(articles[position].media.size>0){
            loadImage(holder.recylerviewArticleItemBinding.articleImage,articles[position].media.get(0).mediametadata.get(0).url)
        }
        holder.recylerviewArticleItemBinding.articleItem.setOnClickListener {
            listener.onRecyclerViewItemClick(holder.recylerviewArticleItemBinding.articleItem, articles[position])
        }
    }


    inner class ArticlesViewHolder(
        val recylerviewArticleItemBinding: ArticleItemBinding
    ) : RecyclerView.ViewHolder(recylerviewArticleItemBinding.root)
}
