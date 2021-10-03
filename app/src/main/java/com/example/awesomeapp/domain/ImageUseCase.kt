package com.example.awesomeapp.domain

import com.example.awesomeapp.data.CuratedPhotos
import com.example.awesomeapp.data.repository.ImageRepository
import com.example.awesomeapp.utils.UseCase
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

open class ImageUseCase @Inject constructor(
    private val repository: ImageRepository,
    dispatcher: CoroutineDispatcher
) : UseCase<Any, CuratedPhotos>(dispatcher) {

    override suspend fun execute(param: Any): CuratedPhotos {
        return repository.getRandomImages()
    }

}