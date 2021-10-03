package com.example.awesomeapp.data.repository

import com.example.awesomeapp.data.CuratedPhotos
import com.example.awesomeapp.data.ImageServices

interface ImageRepository {
    suspend fun getRandomImages(): CuratedPhotos
}

open class ImageRepositoryImpl constructor(
    private val services: ImageServices
) : ImageRepository {

    override suspend fun getRandomImages(): CuratedPhotos {
        return services.getRandomImages("563492ad6f91700001000001b21d39d1c9504f1db391d7d7e345203b")
    }

}