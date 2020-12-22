package net.piedevelopers.realworldiokotlinmvvmretrofit.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import net.piedevelopers.realworldiokotlinmvvmretrofit.FeedAdapter
import net.piedevelopers.realworldiokotlinmvvmretrofit.FeedViewModel
import net.piedevelopers.realworldiokotlinmvvmretrofit.databinding.FeedfragmentLayoutBinding

class GlobalFeedFragment:Fragment() {

    var binding:FeedfragmentLayoutBinding?=null;
    lateinit var viewmodel:FeedViewModel
    lateinit var feedAdapter:FeedAdapter;
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewmodel=ViewModelProvider(this).get(FeedViewModel::class.java)
        binding=FeedfragmentLayoutBinding.inflate(inflater,container,false)
        binding?.feedrecyclerview?.layoutManager=LinearLayoutManager(context)
        binding?.feedrecyclerview?.adapter=feedAdapter;
        viewmodel.fetchglobalfeed()
        return binding?.root
        return super.onCreateView(inflater, container, savedInstanceState)
    }
}