package com.ni3x.marsrover.view_model_factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ni3x.marsrover.data.MarsRoverRepository
import com.ni3x.marsrover.home.HomeViewModel

class HomeViewModelFactory(private val repository: MarsRoverRepository): ViewModelProvider.Factory {

    override fun <T: ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            return HomeViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}