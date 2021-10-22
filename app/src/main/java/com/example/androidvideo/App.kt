package com.example.androidvideo

import android.app.Application
import coil.ImageLoader
import coil.ImageLoaderFactory
import coil.request.CachePolicy
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber
import timber.log.Timber.*


/**
 * Created by Yue on 2021/10/21.
 */
@HiltAndroidApp
class App : Application(), ImageLoaderFactory {

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) Timber.plant(DebugTree())
    }

    //coil recommended that use a singleton ImageLoader.
    //ImageLoader also can be created with hilt, but I can't inject to ViewHolder...
    override fun newImageLoader() = ImageLoader.Builder(applicationContext)
        .diskCachePolicy(CachePolicy.ENABLED)
        .allowRgb565(true)
        .availableMemoryPercentage(0.25)
        .crossfade(true)
        .build()

}