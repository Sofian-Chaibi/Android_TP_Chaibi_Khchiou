package com.example.exempleweb.Network

import retrofit2.http.GET
import com.example.exempleweb.Model.Article
import retrofit2.Call

interface ArticlesService {
    @GET("/articles")
    fun list(): Call<List<Article>>
}