package com.example.germantest.network

import com.example.germantest.model.BrowseApi
import com.example.germantest.model.Post
import retrofit2.http.GET
import retrofit2.http.Url

interface ApiService {
    @GET
    suspend fun getPosts(@Url url: String): BrowseApi
}