package com.example.androidvideo.network

import com.example.androidvideo.bean.VideoBean
import retrofit2.http.GET

/**
 * Created by Yue on 2021/10/21.
 */
interface VideoService {

    // video url: https://gitee.com/qweszxc9160/VideoTest/raw/master/video.json

    @GET("VideoTest/raw/master/video.json")
    suspend fun getVideos(): List<VideoBean>
}