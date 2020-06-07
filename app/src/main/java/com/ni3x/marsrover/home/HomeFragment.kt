package com.ni3x.marsrover.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.ni3x.marsrover.R
import com.ni3x.marsrover.data.MarsRoverRepository
import com.ni3x.marsrover.databinding.FragmentHomeBinding
import com.ni3x.marsrover.home.adapter.MarsPhotoAdapter
import com.ni3x.marsrover.home.adapter.MarsPhotoAdapter.OnClickListener
import com.ni3x.marsrover.view_model_factory.HomeViewModelFactory

class HomeFragment: Fragment() {

    private lateinit var binding: FragmentHomeBinding

    private lateinit var viewModel: HomeViewModel
    lateinit var viewModelFactory: HomeViewModelFactory
    lateinit var adapter: MarsPhotoAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        viewModelFactory = HomeViewModelFactory(MarsRoverRepository())
        viewModel = ViewModelProvider(this, viewModelFactory).get(HomeViewModel::class.java)

        adapter = MarsPhotoAdapter(OnClickListener {
            viewModel.displayPhotoDetail(it)
        })
        bindLiveDataObservers()

        binding.rvPhoto.adapter = adapter
        return binding.root
    }

    fun bindLiveDataObservers() {
        viewModel.photos.observe(viewLifecycleOwner, Observer {
            it?.let { adapter.submitList(it) }
        })


        viewModel.navigateToPhotoDetail.observe(viewLifecycleOwner, Observer {
            if (it != null) {
                this.findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToPhotoViewFragment(it))
                viewModel.displayPhotoDetailComplete()
            }
        })

        viewModel.isLoading.observe(viewLifecycleOwner, Observer {
            if (it) {
                binding.progressBar.visibility = View.VISIBLE
            } else {
                binding.progressBar.visibility = View.GONE
            }
        })

        viewModel.msg.observe(viewLifecycleOwner, Observer {
            if (it.isNotEmpty()){
                Toast.makeText(activity, it, Toast.LENGTH_SHORT).show()
            }
        })
    }
}