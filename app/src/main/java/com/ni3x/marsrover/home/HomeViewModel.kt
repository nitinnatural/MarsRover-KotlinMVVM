package com.ni3x.marsrover.home

import Photos
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ni3x.marsrover.common.Constant
import com.ni3x.marsrover.data.MarsRoverRepository
import com.ni3x.marsrover.data.network.MarsApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class HomeViewModel(repository: MarsRoverRepository): ViewModel() {

    // adding  a backing property to photos so that it cannot be modified from views
    private val _photos = MutableLiveData<List<Photos>>()
    val photos: LiveData<List<Photos>>
        get() = _photos

    private var viewModelJob = Job()
    private val coroutineScope = CoroutineScope(
            viewModelJob + Dispatchers.Main)

    init {
        _photos.value = listOf()
        getPhotoByCuriosity()
    }

    private fun getPhotoByCuriosity() {
        coroutineScope.launch {
            var fetchCurousityDeferred = MarsApi.retrofitService
                    .fetchPhotoOfCuriosity("2012-08-08", 1, Constant.API_KEY)
            try {
                var result = fetchCurousityDeferred.await()
                if (result.photos.size > 0) {
                    _photos.value = result.photos
                } else {
                    Log.i("HomeViewModel", "photo Count is zero")
                }
            } catch (e: Exception) {
                Log.i("HomeViewModel", e.localizedMessage)
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}