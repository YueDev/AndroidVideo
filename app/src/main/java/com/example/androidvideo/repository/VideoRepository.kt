package com.example.androidvideo.repository

import com.example.androidvideo.bean.VideoBean
import com.example.androidvideo.network.VideoService
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.*
import javax.inject.Inject

/**
 * Created by Yue on 2021/10/21.
 */

class VideoRepository @Inject constructor(
    private val videoService: VideoService,
    private val ioDispatcher: CoroutineDispatcher
) {

    fun getVideos() = flow<Resource<List<VideoBean>>> {
        val videos = videoService.getVideos()
        emit(Resource.Success(videos))
    }
        .flowOn(ioDispatcher)
        .onStart {
            emit(Resource.Loading())
        }
        .catch {
            emit(Resource.Error(it.message ?: "Unknown Error!"))
        }
}