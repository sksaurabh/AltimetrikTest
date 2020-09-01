package com.saurabh.tv.altimetriktest.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import com.saurabh.tv.altimetriktest.data.api.ApiHelper
import com.saurabh.tv.altimetriktest.data.model.AlbumSearch
import com.saurabh.tv.altimetriktest.utils.Resource


import kotlinx.coroutines.launch

class ItuneNetworkCallViewModel(
    private val apiHelper: ApiHelper
) : ViewModel() {
    private val itumes = MutableLiveData<Resource<List<AlbumSearch>>>()

    init {
        fetchSearch()
    }

    private fun fetchSearch() {
        viewModelScope.launch {
            itumes.postValue(Resource.loading(null))
            try {
                val itunesFromApi = apiHelper.searchDetails()
                itumes.postValue(Resource.success(itunesFromApi))
            } catch (e: Exception) {
                itumes.postValue(Resource.error(e.toString(), null))
            }
        }
    }

    fun getSearchItune(): LiveData<Resource<List<AlbumSearch>>> {
        return itumes
    }

}