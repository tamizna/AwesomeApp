package com.example.awesomeapp.data

import retrofit2.http.GET
import retrofit2.http.Header

interface ImageServices {

    @GET("v1/curated")
    suspend fun getRandomImages(@Header("Authorization") token : String): CuratedPhotos
}