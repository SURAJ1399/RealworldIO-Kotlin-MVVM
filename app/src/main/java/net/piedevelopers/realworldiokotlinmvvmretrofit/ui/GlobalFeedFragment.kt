package net.piedevelopers.realworldiokotlinmvvmretrofit.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android.rvtutorial.FeedAdapter
import net.piedevelopers.api.response.Article

import net.piedevelopers.realworldiokotlinmvvmretrofit.FeedViewModel
import net.piedevelopers.realworldiokotlinmvvmretrofit.databinding.FeedfragmentLayoutBinding

class GlobalFeedFragment:Fragment() {

    var _binding:FeedfragmentLayoutBinding?=null;
    lateinit var viewModel:FeedViewModel
    lateinit var feedAdapter: FeedAdapter;

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel=ViewModelProvider(this).get(FeedViewModel::class.java)
        val items=viewModel.fetchGlobalFeed()
      feedAdapter = FeedAdapter()
        _binding= FeedfragmentLayoutBinding.inflate(inflater
                ,container,false)
       _binding?.feedRecyclerView?.layoutManager = LinearLayoutManager(context)
       _binding?.feedRecyclerView?.adapter = feedAdapter
        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.feed.observe({ lifecycle }) {
            Log.i("res", it.size.toString())
            feedAdapter.updatefeed(it as ArrayList<Article>)
        }
    }

//    fun openArticle(articleId: String) {
//        findNavController().navigate(
//                R.id.action_globalFeed_openArticle,
//                bundleOf(
//                        resources.getString(R.string.arg_article_id) to articleId
//                )
//        )
//    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}