package com.israfel.muslimmedia

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.israfel.muslimmedia.data.NewsResponse
import com.israfel.muslimmedia.data.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.Query

class NewsViewModel: ViewModel() {
    // Expose screen UI State
    private var _commonMuslimNews = MutableLiveData<NewsResponse>()
    val commonMuslimNews get() = _commonMuslimNews as LiveData<NewsResponse>
    private var _aboutAlQuran = MutableLiveData<NewsResponse>()
    val aboutAlQuran get() = _aboutAlQuran as LiveData<NewsResponse>
    private var _alJazeeraNews = MutableLiveData<NewsResponse>()
    val alJazeeraNews get() = _alJazeeraNews as LiveData<NewsResponse>
    private var _warningForMuslims = MutableLiveData<NewsResponse>()
    val warningForMuslims get() = _warningForMuslims as LiveData<NewsResponse>

    private var _searchNews = MutableLiveData<NewsResponse>()
    val searchNews get() = _searchNews as LiveData<NewsResponse>

    // handle business logic
    fun getCommonMuslimNews() {
        ApiClient.getApiService().getCommonMuslimNews().enqueue(object : Callback<NewsResponse> {
            override fun onResponse(call: Call<NewsResponse>, response: Response<NewsResponse>) {
                if (response.isSuccessful) {
                    Log.i("ViewModel", "onResponse: ${response.body()}")
                    _commonMuslimNews.postValue(response.body())
                } else Log.e(
                    "ViewModel",
                    "onFailedCall: Call error with Http Status Code: " + response.code()
                )
            }

            override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
                Log.e("ViewModel", "onFailure " + t.localizedMessage)
            }
        })
    }

    fun searchNews(query: String) {
        ApiClient.getApiService().searchNews(query).enqueue(object : Callback<NewsResponse> {
            override fun onResponse(call: Call<NewsResponse>, response: Response<NewsResponse>) {
                if (response.isSuccessful) {
                    _searchNews.value = response.body()
                    _searchNews.postValue(response.body())
                } else Log.e("NewsViewModel", "onResponse: ${response.message()}")
            }

            override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
                Log.e("NewsViewModel", "onFailure: ${t.localizedMessage}")
            }

        })
    }
}