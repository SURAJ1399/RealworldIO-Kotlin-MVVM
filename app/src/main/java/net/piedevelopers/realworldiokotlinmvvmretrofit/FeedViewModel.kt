package net.piedevelopers.realworldiokotlinmvvmretrofit

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import net.piedevelopers.api.repo.ArticlesRepo
import net.piedevelopers.api.response.AllArticleResponse
import net.piedevelopers.api.response.Article

class FeedViewModel: ViewModel() {


    private val _feed = MutableLiveData<List<Article>>()
    val feed: LiveData<List<Article>> = _feed

    fun fetchGlobalFeed() = viewModelScope.launch {
        ArticlesRepo.getGlobalFeed().body()?.let {
           _feed.postValue(it.articles)
        }

    }

//    fun fetchMyFeed() = viewModelScope.launch {
//        ArticlesRepo.getMyFeed()?.let {
//            _feed.postValue(it)
//        }
//    }

}
