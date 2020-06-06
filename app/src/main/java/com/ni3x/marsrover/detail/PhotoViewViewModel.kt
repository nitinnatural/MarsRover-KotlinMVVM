package com.ni3x.marsrover.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ni3x.marsrover.data.model.Photos

class PhotoViewViewModel(val photos: Photos): ViewModel() {

    private val _photo = MutableLiveData<Photos>()
    val photo: LiveData<Photos>
        get() = _photo

    init {
        _photo.value = photos
    }
}