package com.powerise.demoapp.home.adapter

import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.RequestManager
import com.powerise.demoapp.R
import com.powerise.demoapp.databinding.RowAlbumBinding
import com.powerise.demoapp.splash.models.AlbumModel

/**
 * Created by Krunal on 09-06-2018.
 */
class AlbumAdapter(private val context: Context, private val glide: RequestManager, private val albumList: ArrayList<AlbumModel>) : RecyclerView.Adapter<AlbumAdapter.ViewHolder>() {

    override fun getItemCount() = albumList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)

        val binding = DataBindingUtil.inflate<RowAlbumBinding>(inflater, R.layout.row_album, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.textTitle.text = albumList[position].title
        glide.load(albumList[position].thumb).into(holder.binding.imgThumb)
    }

    class ViewHolder(val binding: RowAlbumBinding) : RecyclerView.ViewHolder(binding.root)

}