package com.example.awesomeapp.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.awesomeapp.data.CuratedPhotos
import com.example.awesomeapp.data.Result
import com.example.awesomeapp.domain.ImageUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(private val useCase : ImageUseCase) : ViewModel() {

    private val _images = MutableLiveData<CuratedPhotos>()
    val images: LiveData<CuratedPhotos> get() = _images

    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String> get() = _errorMessage

    fun getRandomImages() {
        viewModelScope.launch {
            when (val result = useCase(Unit)) {
                is Result.Success -> _images.value = result.data
                is Result.Error -> _errorMessage.postValue(result.throwable.toString())
            }
        }
    }
}