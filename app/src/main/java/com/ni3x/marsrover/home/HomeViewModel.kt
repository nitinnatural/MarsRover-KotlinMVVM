package com.ni3x.marsrover.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ni3x.marsrover.common.Constant
import com.ni3x.marsrover.data.MarsRoverRepository
import com.ni3x.marsrover.data.model.Photos
import com.ni3x.marsrover.data.network.MarsApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

enum class MarsApiStatus { LOADING, ERROR, DONE }

class HomeViewModel(repository: MarsRoverRepository): ViewModel() {

    // adding  a backing property to photos so that it cannot be modified from views
    private val _photos = MutableLiveData<List<Photos>>()
    val photos: LiveData<List<Photos>>
        get() = _photos

    private val _navigateToPhotoDetail = MutableLiveData<Photos>()
    val navigateToPhotoDetail: LiveData<Photos>
        get() = _navigateToPhotoDetail

    private val _msg = MutableLiveData<String>()
    val msg:LiveData<String>
        get() = _msg

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean>
        get() = _isLoading


    private var viewModelJob = Job()
    private val coroutineScope = CoroutineScope(
            viewModelJob + Dispatchers.Main)

    init {
        _photos.value = listOf()
        _msg.value = ""
        getPhotoByCuriosity()
    }

    private fun getPhotoByCuriosity() {
        coroutineScope.launch {
            _isLoading.value = true
            var fetchCurousityDeferred = MarsApi.retrofitService
                    .fetchPhotoOfCuriosity("2012-08-08", 1, Constant.API_KEY)
            try {
                var result = fetchCurousityDeferred.await()
                _isLoading.value = false
                if (result.photos.isNotEmpty()) {
                    _photos.value = result.photos
                } else {
                    _msg.value = "No photos available"
                }
            } catch (e: Exception) {
                _isLoading.value = false
                _msg.value = "Error fetching photos"
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

    fun displayPhotoDetail(photos: Photos) {
        _navigateToPhotoDetail.value = photos
    }

    fun displayPhotoDetailComplete() {
        _navigateToPhotoDetail.value = null
    }
}