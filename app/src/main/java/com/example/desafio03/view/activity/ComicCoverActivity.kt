package com.example.desafio03.view.activity

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.desafio03.databinding.ActivityComicCoverBinding
import com.example.desafio03.model.Thumbnail
import com.example.desafio03.util.Constants
import com.example.desafio03.util.Constants.Intent.KEY_COMIC_IMAGE


class ComicCoverActivity : AppCompatActivity() {

    private lateinit var binding: ActivityComicCoverBinding

    override fun onCreate(savedInstanceState:Bundle?){
        super.onCreate(savedInstanceState)
        binding = ActivityComicCoverBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initComponents()
        setupObservables()

    }

    private fun setupObservables() {
        binding.ivHqCoverImage.setOnClickListener { finish() }
        binding.ivHqCoverImage.setOnClickListener { finish() }
    }

    private fun initComponents() {
        val comicImage: Thumbnail? = intent.getParcelableExtra<Thumbnail>(KEY_COMIC_IMAGE)
        Glide.with(this)
                .load("${comicImage?.path?.replace("http","https")}.${comicImage?.extension}").into(binding.ivHqCoverImage)
    }

}