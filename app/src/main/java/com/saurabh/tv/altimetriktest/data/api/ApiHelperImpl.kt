package com.saurabh.tv.altimetriktest.data.api



class ApiHelperImpl(private val apiService: ApiService) : ApiHelper {

    override suspend fun searchDetails() = apiService.getSearch("Need to pass the search param")

}