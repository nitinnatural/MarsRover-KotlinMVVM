package com.ni3x.marsrover.view_model_factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ni3x.marsrover.data.model.Photos
import com.ni3x.marsrover.detail.PhotoViewViewModel
import com.ni3x.marsrover.home.HomeViewModel

class PhotoViewViewModelFactory(private val photos:Photos): ViewModelProvider.Factory {

    override fun <T: ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PhotoViewViewModel::class.java)) {
            return PhotoViewViewModel(photos) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}