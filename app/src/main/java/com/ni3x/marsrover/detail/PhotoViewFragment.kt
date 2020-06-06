package com.ni3x.marsrover.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.ni3x.marsrover.R
import com.ni3x.marsrover.databinding.FragmentPhotoViewBinding

class PhotoViewFragment: Fragment() {

    lateinit var binding: FragmentPhotoViewBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_photo_view, container, false)

        return binding.root
    }
}