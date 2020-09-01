package com.saurabh.tv.altimetriktest.utils
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.saurabh.tv.altimetriktest.data.api.ApiHelper
import com.saurabh.tv.altimetriktest.viewmodel.ItuneNetworkCallViewModel


class ViewModelFactory(private val apiHelper: ApiHelper) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ItuneNetworkCallViewModel::class.java)) {
            return ItuneNetworkCallViewModel(apiHelper) as T
        }

        throw IllegalArgumentException("Unknown class name")
    }

}