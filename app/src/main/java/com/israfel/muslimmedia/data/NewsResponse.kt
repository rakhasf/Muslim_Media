package com.israfel.muslimmedia.data

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@JsonClass(generateAdapter = true)
data class NewsResponse(

	@Json(name="totalResults")
	val totalResults: Int? = null,

	@Json(name="articles")
	val articles: List<ArticlesItem>? = null,

	@Json(name="status")
	val status: String? = null
)

@JsonClass(generateAdapter = true)
data class Source(

	@Json(name="name")
	val name: String? = null,

	@Json(name="id")
	val id: Any? = null
)

@Parcelize
@JsonClass(generateAdapter = true)
data class ArticlesItem(

	@Json(name="publishedAt")
	val publishedAt: String? = null,

	@Json(name="author")
	val author: String? = null,

	@Json(name="urlToImage")
	val urlToImage: String? = null,

	@Json(name="description")
	val description: String? = null,

	@Json(name="title")
	val title: String? = null,

	@Json(name="url")
	val url: String? = null,

	@Json(name="content")
	val content: String? = null
) : Parcelable
