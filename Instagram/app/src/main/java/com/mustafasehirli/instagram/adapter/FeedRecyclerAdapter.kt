package com.mustafasehirli.instagram.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mustafasehirli.instagram.R
import com.mustafasehirli.instagram.databinding.RecyclerRowBinding
import com.mustafasehirli.instagram.model.Post
import com.squareup.picasso.Picasso

class FeedRecyclerAdapter(private val mContext:Context, private val postArrayList:List<Post>):
    RecyclerView.Adapter<FeedRecyclerAdapter.RecyclerHolder>() {

    class RecyclerHolder(val binding:RecyclerRowBinding):RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerHolder {
        val binding =RecyclerRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return RecyclerHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerHolder, position: Int) {
        holder.binding.recylerEmailText.text=postArrayList.get(position).email
        holder.binding.recyclerCommentText.text=postArrayList.get(position).comment
        Picasso.get().load(postArrayList.get(position).downloadUrl).into(holder.binding.recyclImageView)
    }

    override fun getItemCount(): Int {
        return postArrayList.size
    }
}