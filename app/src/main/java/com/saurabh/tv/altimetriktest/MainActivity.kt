package com.saurabh.tv.altimetriktest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.saurabh.tv.altimetriktest.ui.ItuneSearchDetailsActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun startItuneSearchDetailsActivity(view: View) {
        startActivity(Intent(this@MainActivity, ItuneSearchDetailsActivity::class.java))
    }

}