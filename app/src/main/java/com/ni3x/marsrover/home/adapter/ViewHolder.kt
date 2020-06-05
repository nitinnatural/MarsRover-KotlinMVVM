package com.ni3x.marsrover.home.adapter

import Photos
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ni3x.marsrover.R
import com.ni3x.marsrover.R.layout

class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    private val ivPhoto = itemView.findViewById<ImageView>(R.id.iv_photo)

    fun bindData(photo: Photos) {
        Glide.with(itemView.context).load(photo.img_src).into(ivPhoto)
    }

    companion object {
        fun from(parent: ViewGroup): ViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val view = layoutInflater.inflate(layout.list_view_row, parent, false)
            return ViewHolder(view)
        }
    }
}
