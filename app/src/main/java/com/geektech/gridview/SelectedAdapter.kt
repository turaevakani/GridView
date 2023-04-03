package com.geektech.gridview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.geektech.gridview.databinding.ItemGridviewBinding

class SelectedAdapter (val selectedPhotosList: ArrayList<GridViewModal>) :
    RecyclerView.Adapter<SelectedAdapter.ViewHolder>() {
    inner class ViewHolder(private val binding: ItemGridviewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            val itemsGV = selectedPhotosList[adapterPosition]
            binding.ivPhoto.loadImage(itemsGV.image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemGridviewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount(): Int {
        return selectedPhotosList.size
    }
}