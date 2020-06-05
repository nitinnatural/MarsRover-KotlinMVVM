package com.ni3x.marsrover.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ni3x.marsrover.data.MarsRoverRepository
import com.ni3x.marsrover.data.model.Dataset
import com.ni3x.marsrover.data.model.Photo
import com.ni3x.marsrover.data.network.ApiEndpointInterface
import com.ni3x.marsrover.data.network.MarsApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeViewModel(repository: MarsRoverRepository): ViewModel() {

    // adding  a backing property to photos so that it cannot be modified from views
    private val _photos = MutableLiveData<List<Photo>>()
    val photos: LiveData<List<Photo>>
        get() = _photos

    init {
        _photos.value = listOf()
    }


    private fun getPhotoByCuriosity(){
        MarsApi.retrofitService
                .getPhotoByCuriosity("", 1, "")
                .enqueue(object : Callback<Dataset>{
                    override fun onFailure(call: Call<Dataset>, t: Throwable) {
                        // send msg error happend
                    }
                    override fun onResponse(call: Call<Dataset>, response: Response<Dataset>) {
                        _photos.value = response.body()?.photos
                    }
                })
    }

}