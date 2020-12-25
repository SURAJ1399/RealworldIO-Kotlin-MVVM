package com.example.android.rvtutorial



import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncDifferConfig
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import net.piedevelopers.api.response.Article
import net.piedevelopers.realworldiokotlinmvvmretrofit.R


class FeedAdapter(config: AsyncDifferConfig<Article>) :
    ListAdapter<Article, FeedAdapter.ViewHolder>(config) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedAdapter.ViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: FeedAdapter.ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }


        class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        // Holds the TextView that will add each animal to
//    val tvAnimalType = view.tv_animal_type
    }
}