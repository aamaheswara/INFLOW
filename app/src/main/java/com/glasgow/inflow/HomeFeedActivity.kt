package com.glasgow.inflow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.glasgow.inflow.models.ReviewPost
import com.glasgow.inflow.R.layout.activity_home_feed.*
import org.json.JSONArray
import org.json.JSONObject
import java.io.IOException
import java.io.InputStream

class HomeFeedActivity : AppCompatActivity() {

    private lateinit var reviewAdapter: FeedRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_feed)
        initRecyclerView()
        addDataset()
    }

    private fun addDataset(){
        val data = DataSource.createDataSet()
        reviewAdapter.submitList(data)
    }

    private fun initRecyclerView(){
        recycler_view.apply{
            layoutManager = LinearLayoutManager(this@HomeFeedActivity)
            val topSpacingDecoration = TopSpacingItemDecoration(30)
            reviewAdapter = FeedRecyclerAdapter()
            adapter = reviewAdapter
        }
    }
}