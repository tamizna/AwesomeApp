package com.example.awesomeapp.di.modules

import com.example.awesomeapp.data.ImageServices
import com.example.awesomeapp.data.repository.ImageRepository
import com.example.awesomeapp.data.repository.ImageRepositoryImpl
import com.example.awesomeapp.network.Network
import dagger.Module
import dagger.Provides


@Module
open class ApiModule() {
    @Provides
    fun provideImageServices(): ImageServices {
        return Network.builder().create(ImageServices::class.java)
    }

    @Provides
    fun provideImageRepository(imageServices: ImageServices): ImageRepository {
        return ImageRepositoryImpl(imageServices)
    }
}