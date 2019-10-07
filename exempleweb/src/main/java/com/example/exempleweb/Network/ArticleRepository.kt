package com.example.exempleweb.Network

import com.example.exempleweb.Model.Article
import retrofit2.Retrofit

//4d9b6694e8bd43bf9fee6a95bcc773d8
class ArticleRepository () {
    private val service: ArticlesService
    init {
        val retrofit = Retrofit.Builder().apply {
            baseUrl("https://newsapi.org/v2/everything?q=bitcoin&from=2019-08-25&sortBy=publishedAt&apiKey=4d9b6694e8bd43bf9fee6a95bcc773d8")
        }.build()
        service = retrofit.create(ArticlesService::class.java)
    }

    fun list(): List<Article> {
        val response =  service.list().execute()
        return response.body() ?: emptyList()
    }
}