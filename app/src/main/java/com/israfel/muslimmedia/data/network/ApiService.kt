package com.israfel.muslimmedia.data.network

import com.israfel.muslimmedia.data.NewsResponse
import com.israfel.muslimmedia.data.Source
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("everything")
    fun getCommonMuslimNews(
        @Query("q") keyword: String = "islam",
        @Query("language") language: String = "en",
        @Query("sortBy") sortBy: String = "popularity",
        @Query("pageSize") pageSize: Int = 30
    ) : Call<NewsResponse>

    @GET("everything")
    fun getAboutAlQuranNews(
        @Query("q") keyword: String = "Al Quran",
        @Query("language") language: String = "en"
    ) : Call<NewsResponse>

    @GET("top-headlines")
    fun getAlJazeeraNews(
        @Query("sources") source: String = "al-jazeera-english"
    ) : Call<NewsResponse>

    @GET("everything")
    fun getWarningForIslam(
        @Query("q") keyword: String = "anti islam"
    ) : Call<NewsResponse>

    @GET("everything")
    fun searchNews(
        @Query("q") query: String,
        @Query("PageSize") pageSize: Int = 50
    ) : Call<NewsResponse>
}