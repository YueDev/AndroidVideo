package com.example.androidvideo.gallery_new

import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by Yue on 2021/12/31.
 * add gallery test.
 */
interface GalleryServices {

    //https://amlyu.com/page/2/
    //分页请求
    @GET("page/{page}/")
    suspend fun getPhotos(
        @Path("page")
        page: Int
    ): ResponseBody

}