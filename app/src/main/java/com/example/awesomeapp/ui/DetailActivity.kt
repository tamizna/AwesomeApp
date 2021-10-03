package com.example.awesomeapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.awesomeapp.R
import com.example.awesomeapp.data.Photo
import com.example.awesomeapp.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle = intent.extras

        val dataPhoto: Photo = bundle?.getSerializable("photo") as Photo

        initView(dataPhoto)
    }

    private fun initView(photo: Photo) {
        Glide.with(this).load(photo.src.large).placeholder(R.drawable.ic_loading)
            .into(binding.imgDetailPhoto)

        binding.tvDetail.text = photo.photographer
    }
}