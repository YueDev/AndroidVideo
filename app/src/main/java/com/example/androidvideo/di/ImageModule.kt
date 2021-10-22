package com.example.androidvideo.di

import android.content.Context
import coil.ImageLoader
import coil.request.CachePolicy
import com.example.androidvideo.network.VideoService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.create
import javax.inject.Singleton

/**
 * Created by Yue on 2021/10/22.
 */
//@Module
//@InstallIn(SingletonComponent::class)
//object ImageModule {
//
//    @Provides
//    @Singleton
//    fun provideImageLoader(applicationContext: Context): ImageLoader {
//        return ImageLoader.Builder(applicationContext)
//            .diskCachePolicy(CachePolicy.ENABLED)
//            .build()
//    }
//
//}