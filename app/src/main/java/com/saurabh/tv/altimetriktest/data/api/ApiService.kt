package com.saurabh.tv.altimetriktest.data.api


import com.saurabh.tv.altimetriktest.data.model.AlbumSearch
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
   // Proper Json url i don't have
    @GET("search")
    suspend fun getSearch(@Query("term") all: String): List<AlbumSearch>
}