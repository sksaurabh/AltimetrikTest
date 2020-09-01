package com.saurabh.tv.altimetriktest.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.saurabh.tv.altimetriktest.R
import com.saurabh.tv.altimetriktest.base.ItuneAdapter
import com.saurabh.tv.altimetriktest.data.api.ApiHelperImpl
import com.saurabh.tv.altimetriktest.data.api.RetrofitBuilder
import com.saurabh.tv.altimetriktest.data.model.AlbumSearch
import com.saurabh.tv.altimetriktest.utils.Status
import com.saurabh.tv.altimetriktest.utils.ViewModelFactory
import com.saurabh.tv.altimetriktest.viewmodel.ItuneNetworkCallViewModel
import kotlinx.android.synthetic.main.activity_recycler_view.*


class ItuneSearchDetailsActivity : AppCompatActivity() {

    private lateinit var viewModel: ItuneNetworkCallViewModel
    private lateinit var adapter: ItuneAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)
        setupUI()
        setupViewModel()
        setupObserver()
    }

    private fun setupUI() {
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter =
            ItuneAdapter(
                arrayListOf()
            )
        recyclerView.addItemDecoration(
            DividerItemDecoration(
                recyclerView.context,
                (recyclerView.layoutManager as LinearLayoutManager).orientation
            )
        )
        recyclerView.adapter = adapter
    }

    private fun setupObserver() {
        viewModel.getSearchItune().observe(this, Observer {
            when (it.status) {
                Status.SUCCESS -> {
                    progressBar.visibility = View.GONE
                    it.data?.let { itunes -> renderList(itunes.component1()) }
                    recyclerView.visibility = View.VISIBLE
                }
                Status.LOADING -> {
                    progressBar.visibility = View.VISIBLE
                    recyclerView.visibility = View.GONE
                }
                Status.ERROR -> {
                    //Handle Error
                    progressBar.visibility = View.GONE
                    Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                }
            }
        })
    }

    private fun renderList(itunes: AlbumSearch) {
        adapter.addData(itunes.results)
        adapter.notifyDataSetChanged()
    }

    private fun setupViewModel() {
        viewModel = ViewModelProviders.of(
            this,
            ViewModelFactory(
                ApiHelperImpl(RetrofitBuilder.apiService)
            )
        ).get(ItuneNetworkCallViewModel::class.java)
    }
}
