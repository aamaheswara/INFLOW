package com.glasgow.inflow

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.glasgow.inflow.R.layout.custom_feed_design
import kotlinx.android.synthetic.main.custom_feed_design.view.*
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.glasgow.inflow.models.ReviewPost
import kotlin.collections.ArrayList
import androidx.appcompat.view.menu.ActionMenuItemView

class FeedRecyclerAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    private var items: List<ReviewPost> = ArrayList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return  FeedViewHolder(
            LayoutInflater.from(parent.context).inflate(custom_feed_design ,parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is FeedViewHolder ->{
                holder.bind(items.get(position))
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun submitList(postList: List<ReviewPost>){
        items = postList
    }

    class  FeedViewHolder constructor(
        itemView: View
    ): RecyclerView.ViewHolder(itemView){
        val postImage = itemView.post_image
        val postTitle = itemView.post_title
        val postAuthor = itemView.post_author

        fun bind(reviewPost: ReviewPost){
            postTitle.setText(reviewPost.title)
            postAuthor.setText(reviewPost.username)

            // glide ==> image loading library
            val requestOptions = RequestOptions()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)
            Glide.with(itemView.context)
                .applyDefaultRequestOptions(requestOptions)
                .load(reviewPost.image)
                .into(postImage)
        }
    }
}