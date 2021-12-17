package com.glasgow.inflow

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.glasgow.inflow.fragments.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var blogAdapter: BlogRecyclerAdapter
    private val feedDataset = DataSource.createDataSet()

    //fragment implementation reference: https://youtu.be/v8MbOjBCu0o
    private val myHomeFeedFragment = HomeFeedFragment()
    private val mySearchFragment   = SearchFragment()
    private val myNewPostFragment  = NewPostFragment()
    private val myGamificationFragment = GamificationFragment()
    private val myProfileFragment  = ProfileFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        replaceFragment(myHomeFeedFragment)
        bottom_nav.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.ic_home -> replaceFragment(myHomeFeedFragment)
                R.id.ic_search -> replaceFragment(mySearchFragment)
                R.id.ic_new_post -> replaceFragment(myNewPostFragment)
                R.id.ic_gamification -> replaceFragment(myGamificationFragment)
                R.id.ic_account -> replaceFragment(myProfileFragment)
            }
            true
        }

    }

    private fun replaceFragment(fragment: Fragment){
        if (fragment != null && fragment != this.myHomeFeedFragment){
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container, fragment)
            transaction.commit()
//            initRecyclerView()
            clearItemsRecyclerView()
        } else if (fragment != null && fragment == this.myHomeFeedFragment){
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container, fragment)
            transaction.commit()
            initRecyclerView()
            addDataset()
        }
    }

    fun fToProfile(view: View){
        val myIntent = Intent(this, UserProfileActivity::class.java)
        startActivity(myIntent)
    }

    private fun clearItemsRecyclerView(){
        this.feedDataset.clear()
        blogAdapter.notifyDataSetChanged()
    }

    private fun addDataset(){
        if (this.feedDataset.isEmpty()){
            this.feedDataset.addAll(DataSource.createDataSet())
        }
        blogAdapter.submitList(this.feedDataset)
    }

    private fun initRecyclerView(){
        recycler_view.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            val topSpacingDecorator = TopSpacingItemDecoration(30)
            addItemDecoration(topSpacingDecorator)
            blogAdapter = BlogRecyclerAdapter()
            adapter = blogAdapter
        }
    }
}