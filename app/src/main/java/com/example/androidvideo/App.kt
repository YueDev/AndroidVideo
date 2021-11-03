package com.example.androidvideo

import android.app.Application
import coil.ImageLoader
import coil.ImageLoaderFactory
import coil.request.CachePolicy
import coil.util.CoilUtils
import dagger.hilt.android.HiltAndroidApp
import okhttp3.OkHttpClient
import timber.log.Timber
import timber.log.Timber.*


/**
 * Created by Yue on 2021/10/21.
 */
@HiltAndroidApp
class App : Application() {

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) Timber.plant(DebugTree())
    }

    //coil recommended that use a singleton ImageLoader.
    //ImageLoader also can be created with hilt, but I can't inject to ViewHolder...
//    override fun newImageLoader() = ImageLoader.Builder(applicationContext)
//        .allowRgb565(true)
//        .availableMemoryPercentage(0.25)
//        .diskCachePolicy(CachePolicy.ENABLED)
//        .okHttpClient {
//            OkHttpClient.Builder().cache(CoilUtils.createDefaultCache(applicationContext)).build()
//        }
//        .crossfade(true)
//        .build()

}