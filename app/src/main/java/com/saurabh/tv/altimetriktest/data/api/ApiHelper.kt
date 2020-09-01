package com.saurabh.tv.altimetriktest.data.api


import com.saurabh.tv.altimetriktest.data.model.AlbumSearch

interface ApiHelper {

    suspend fun searchDetails(): List<AlbumSearch>
}