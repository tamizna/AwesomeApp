package com.example.awesomeapp.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.awesomeapp.R
import com.example.awesomeapp.data.Photo
import com.example.awesomeapp.databinding.ItemGridImageBinding
import com.example.awesomeapp.databinding.ItemListImageBinding

class ImageAdapter constructor(
    private val images: MutableList<Photo> = mutableListOf(),
    private var itemType: Int = 0, private val onItemClick : (Photo) -> Unit
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        const val GRID_VIEW = 0
        const val LIST_VIEW = 1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return when(viewType) {
            GRID_VIEW -> {
                GridViewHolder(ItemGridImageBinding.inflate(inflater, parent, false))
            }
            LIST_VIEW -> {
                ListViewHolder(ItemListImageBinding.inflate(inflater, parent, false))
            }
            else -> throw IllegalArgumentException("Undefined view type")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder.itemViewType) {
            GRID_VIEW -> {
                val gridHolder = holder as GridViewHolder
                gridHolder.bind(images[position])
            }

            LIST_VIEW -> {
                val listHolder = holder as ListViewHolder
                listHolder.bind(images[position])
            }
        }
    }

    override fun getItemCount(): Int = images.size

    override fun getItemViewType(position: Int): Int {
        return when (itemType) {
            0 -> GRID_VIEW
            1 -> LIST_VIEW
            else -> throw IllegalArgumentException("Invalid type of data " + position)
        }
    }

    fun addData(newData: List<Photo>) {
        images.clear()
        images.addAll(newData)
        notifyDataSetChanged()
    }

    fun changeTypeView(newType : Int) {
        itemType = newType
        notifyDataSetChanged()
    }

    inner class ListViewHolder(private val view: ItemListImageBinding) :
        RecyclerView.ViewHolder(view.root) {
        fun bind(photo: Photo) {
            with(view) {
                tvPhotographer.text = photo.photographer
                Glide.with(imgPhoto.context).load(photo.src.small).placeholder(R.drawable.ic_loading).into(imgPhoto)

                root.setOnClickListener {
                    onItemClick(photo)
                }
            }
        }
    }

    inner class GridViewHolder(private val view: ItemGridImageBinding) :
        RecyclerView.ViewHolder(view.root) {
        fun bind(photo: Photo) {
            with(view) {
                tvPhotographer.text = photo.photographer
                Glide.with(imgPhoto.context).load(photo.src.medium).placeholder(R.drawable.ic_loading).into(imgPhoto)

                root.setOnClickListener {
                    onItemClick(photo)
                }
            }
        }

    }
}