package com.example.awesomeapp.data

import java.io.Serializable

data class CuratedPhotos(
    val nextPage: String,
    val page: Int,
    val perPage: Int,
    val photos: List<Photo>,
    val totalResults: Int
)

data class Photo(
    val avgColor: String,
    val height: Int,
    val id: Int,
    val liked: Boolean,
    val photographer: String,
    val photographerId: Int,
    val photographerUrl: String,
    val src: Src,
    val url: String,
    val width: Int
) : Serializable

data class Src(
    val landscape: String,
    val large: String,
    val large2x: String,
    val medium: String,
    val original: String,
    val portrait: String,
    val small: String,
    val tiny: String
) : Serializable