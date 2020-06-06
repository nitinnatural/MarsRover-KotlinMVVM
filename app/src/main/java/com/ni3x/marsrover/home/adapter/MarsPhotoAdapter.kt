package com.ni3x.marsrover.home.adapter


import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.ni3x.marsrover.data.model.Photos

class MarsPhotoAdapter(private val onClickListener: OnClickListener): ListAdapter<Photos, ViewHolder>(MarsPhotoDiffCallback()) {

    class MarsPhotoDiffCallback: DiffUtil.ItemCallback<Photos>() {
        override fun areItemsTheSame(oldItem: Photos, newItem: Photos): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Photos, newItem: Photos): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val photo = getItem(position)
        holder.itemView.setOnClickListener{
            onClickListener.onClick(photo)
        }
        holder.bindData(photo)
    }

    class OnClickListener(val clickListener: (photo:Photos)-> Unit) {
        fun onClick(photo:Photos) = clickListener(photo)
    }
}