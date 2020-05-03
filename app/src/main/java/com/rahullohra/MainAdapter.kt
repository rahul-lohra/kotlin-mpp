package com.rahullohra

import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class MainAdapter(val data: ArrayList<String>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ImageViewHolder(parent)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ImageViewHolder).bind(data[position])
    }
}

class ImageViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(AspectRatioImageView(parent.context).apply {
    scaleType = ImageView.ScaleType.CENTER_CROP
}) {
    fun bind(item: String) {
        itemView.tag = item
    }
}