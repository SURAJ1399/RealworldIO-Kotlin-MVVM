package com.example.android.rvtutorial




import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.recyclerview.widget.RecyclerView
import net.piedevelopers.api.response.Article
import net.piedevelopers.realworldiokotlinmvvmretrofit.R
import net.piedevelopers.realworldiokotlinmvvmretrofit.databinding.ListItemArticleBinding


class FeedAdapter():RecyclerView.Adapter<FeedViewHolder>(){

    val article:ArrayList<Article> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedViewHolder {

        return FeedViewHolder(
                parent.context.getSystemService(LayoutInflater::class.java).inflate(
                        R.layout.list_item_article,
                        parent,
                        false
                )
        )
    }

    override fun getItemCount(): Int {

   return article.size
    }

    override fun onBindViewHolder(holder: FeedViewHolder, position: Int) {

                ListItemArticleBinding.bind(holder.itemView).apply {
                    Log.i("title",article[position].title)
                    titleTextView.text=article.get(position).title
                  bodySnippetTextView.text=article.get(position).body
                }
    }

            fun updatefeed(updatefeed:ArrayList<Article>)
            {
                Log.i("respo",updatefeed.size.toString())
                article.clear();
                article.addAll(updatefeed)
                notifyDataSetChanged()
            }

}

class FeedViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {



}
