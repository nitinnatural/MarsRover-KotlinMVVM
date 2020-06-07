package com.ni3x.marsrover.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.ni3x.marsrover.R
import com.ni3x.marsrover.data.MarsRoverRepository
import com.ni3x.marsrover.data.model.Photos
import com.ni3x.marsrover.databinding.FragmentPhotoViewBinding
import com.ni3x.marsrover.home.HomeViewModel
import com.ni3x.marsrover.view_model_factory.HomeViewModelFactory
import com.ni3x.marsrover.view_model_factory.PhotoViewViewModelFactory

class PhotoViewFragment: Fragment() {

    lateinit var binding: FragmentPhotoViewBinding
    lateinit var viewModel: PhotoViewViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_photo_view, container, false)
        val photo = PhotoViewFragmentArgs.fromBundle(requireArguments()).argsPhoto
        val viewModelFactory = PhotoViewViewModelFactory(photo)
        viewModel = ViewModelProvider(this, viewModelFactory).get(PhotoViewViewModel::class.java)

        viewModel.photo.observe(viewLifecycleOwner, Observer {
            Glide.with(this).load(photo.img_src).into(binding.zoomView)
        })

        return binding.root
    }
}