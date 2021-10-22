package com.example.androidvideo.bean

import com.google.gson.annotations.SerializedName

data class VideoBean(
    @SerializedName("video_id") val videoId: String,
    @SerializedName("video_title") val videoTitle: String,
    @SerializedName("video_file_name") val videoFileName: String,
    @SerializedName("video_url") val videoUrl: String,
    @SerializedName("img_url") val imgUrl: String,
    @SerializedName("description") val description: String,
    @SerializedName("user_name") val userName: String,
    @SerializedName("user_avatar") val userAvatar: String
)
