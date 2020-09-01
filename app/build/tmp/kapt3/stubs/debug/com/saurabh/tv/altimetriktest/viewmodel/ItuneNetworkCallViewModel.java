package com.saurabh.tv.altimetriktest.viewmodel;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\n\u001a\u00020\u000bH\u0002J\u0018\u0010\f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00070\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010\u0005\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Lcom/saurabh/tv/altimetriktest/viewmodel/ItuneNetworkCallViewModel;", "Landroidx/lifecycle/ViewModel;", "apiHelper", "Lcom/saurabh/tv/altimetriktest/data/api/ApiHelper;", "(Lcom/saurabh/tv/altimetriktest/data/api/ApiHelper;)V", "itumes", "Landroidx/lifecycle/MutableLiveData;", "Lcom/saurabh/tv/altimetriktest/utils/Resource;", "", "Lcom/saurabh/tv/altimetriktest/data/model/AlbumSearch;", "fetchSearch", "", "getSearchItune", "Landroidx/lifecycle/LiveData;", "app_debug"})
public final class ItuneNetworkCallViewModel extends androidx.lifecycle.ViewModel {
    private final androidx.lifecycle.MutableLiveData<com.saurabh.tv.altimetriktest.utils.Resource<java.util.List<com.saurabh.tv.altimetriktest.data.model.AlbumSearch>>> itumes = null;
    private final com.saurabh.tv.altimetriktest.data.api.ApiHelper apiHelper = null;
    
    private final void fetchSearch() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.saurabh.tv.altimetriktest.utils.Resource<java.util.List<com.saurabh.tv.altimetriktest.data.model.AlbumSearch>>> getSearchItune() {
        return null;
    }
    
    public ItuneNetworkCallViewModel(@org.jetbrains.annotations.NotNull()
    com.saurabh.tv.altimetriktest.data.api.ApiHelper apiHelper) {
        super();
    }
}