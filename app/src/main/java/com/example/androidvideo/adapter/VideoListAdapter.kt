package com.example.androidvideo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.androidvideo.R
import com.example.androidvideo.bean.VideoBean
import javax.inject.Inject

/**
 * Created by Yue on 2021/10/22.
 */

class VideoListAdapter @Inject constructor() : ListAdapter<VideoBean, VideoListAdapter.VideoHolder>(VideoBeanDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_video_list, parent, false)
        return VideoHolder((itemView))
    }

    override fun onBindViewHolder(holder: VideoHolder, position: Int) {
        holder.bind(getItem(position))
    }


    class VideoHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val imageView = itemView.findViewById<ImageView>(R.id.imageView)
        private val titleTextView = itemView.findViewById<TextView>(R.id.titleTextView)
        private val authorTextView = itemView.findViewById<TextView>(R.id.authorTextView)

        fun bind(videoBean: VideoBean) {

            //coil's disk cache use okhttp cache. if there is network,it seems not used.
            //use glide to load image.
            Glide.with(imageView.context).load(videoBean.imgUrl).into(imageView)
            titleTextView.text = videoBean.videoTitle
            authorTextView.text = videoBean.userName
        }
    }

}