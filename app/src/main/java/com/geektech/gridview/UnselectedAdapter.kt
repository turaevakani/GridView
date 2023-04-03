package com.geektech.gridview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView
import com.geektech.gridview.databinding.ItemGridviewBinding

class UnselectedAdapter (
    private val unselectedPhotosList: ArrayList<GridViewModal>,
    val addImage: (itemGV: GridViewModal) -> Unit,
    val removeImage: (itemGV: GridViewModal) -> Unit
) : Adapter<UnselectedAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder( ItemGridviewBinding.inflate( LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(unselectedPhotosList[position])
    }

    override fun getItemCount(): Int {
        return unselectedPhotosList.size
    }

    inner class ViewHolder(private val binding: ItemGridviewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(itemGV: GridViewModal) {
            binding.ivPhoto.loadImage(itemGV.image)

            itemView.setOnClickListener {
                itemGV.isSelected = !itemGV.isSelected

                if (itemGV.isSelected) {
                    binding.ivPhoto.alpha = 0.5f
                    addImage(itemGV)
                } else  {
                    removeImage(itemGV)
                    binding.ivPhoto.alpha = 1.0f
                }
            }
        }
    }
}