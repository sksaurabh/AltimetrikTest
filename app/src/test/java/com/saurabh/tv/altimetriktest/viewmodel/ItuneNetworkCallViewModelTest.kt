package com.saurabh.tv.altimetriktest.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.saurabh.tv.altimetriktest.data.api.ApiHelper
import com.saurabh.tv.altimetriktest.data.model.AlbumSearch
import com.saurabh.tv.altimetriktest.utils.Resource
import com.saurabh.tv.altimetriktest.utils.TestCoroutineRule

import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class ItuneNetworkCallViewModelTest {

    @get:Rule
    val testInstantTaskExecutorRule: TestRule = InstantTaskExecutorRule()

    @get:Rule
    val testCoroutineRule = TestCoroutineRule()

    @Mock
    private lateinit var apiHelper: ApiHelper


    @Mock
    private lateinit var apiUsersObserver: Observer<Resource<List<AlbumSearch>>>

    @Before
    fun setUp() {
        // do something if required
    }

    @Test
    fun givenServerResponse200_whenFetch_shouldReturnSuccess() {
        testCoroutineRule.runBlockingTest {
            doReturn(emptyList<AlbumSearch>())
                .`when`(apiHelper)
                .searchDetails()
            val viewModel = ItuneNetworkCallViewModel(apiHelper)
            viewModel.getSearchItune().observeForever(apiUsersObserver)
            verify(apiHelper).searchDetails()
            verify(apiUsersObserver).onChanged(Resource.success(emptyList()))
            viewModel.getSearchItune().removeObserver(apiUsersObserver)
        }
    }

    @Test
    fun givenServerResponseError_whenFetch_shouldReturnError() {
        testCoroutineRule.runBlockingTest {
            val errorMessage = "Error Message For You"
            doThrow(RuntimeException(errorMessage))
                .`when`(apiHelper)
                .searchDetails()
            val viewModel = ItuneNetworkCallViewModel(apiHelper)
            viewModel.getSearchItune().observeForever(apiUsersObserver)
            verify(apiHelper).searchDetails()
            verify(apiUsersObserver).onChanged(
                Resource.error(
                    RuntimeException(errorMessage).toString(),
                    null
                )
            )
            viewModel.getSearchItune().removeObserver(apiUsersObserver)
        }
    }

    @After
    fun tearDown() {
        // do something if required
    }

}