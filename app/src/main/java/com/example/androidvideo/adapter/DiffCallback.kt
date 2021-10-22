package com.example.androidvideo.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.androidvideo.bean.VideoBean

/**
 * Created by Yue on 2021/10/22.
 */
object VideoBeanDiffCallback : DiffUtil.ItemCallback<VideoBean>() {
    override fun areItemsTheSame(oldItem: VideoBean, newItem: VideoBean): Boolean {
        return oldItem.videoId == newItem.videoId
    }

    override fun areContentsTheSame(oldItem: VideoBean, newItem: VideoBean): Boolean {
        return oldItem == newItem
    }
}