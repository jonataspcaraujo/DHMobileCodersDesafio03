package com.example.desafio03.view.activity

import android.content.Intent
import android.annotation.SuppressLint
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import com.bumptech.glide.Glide
import com.example.desafio03.databinding.ActivityComicDetailBinding
import com.example.desafio03.model.Result
import com.example.desafio03.util.Constants.Intent.KEY_COMIC_IMAGE
import com.example.desafio03.util.Constants.Intent.KEY_COMIC_RESULT



class ComicDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityComicDetailBinding
    private var comic: Result? = null

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityComicDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        comic = intent.getParcelableExtra(KEY_COMIC_RESULT)
        initComponents()
        setupObservables()

    }

    @SuppressLint("SetTextI18n")
    private fun setupObservables() {

        binding.ivHqDetailCover.setOnClickListener {
            val intent = Intent(this@ComicDetailActivity, ComicCoverActivity::class.java)
            intent.putExtra(KEY_COMIC_IMAGE,comic?.thumbnail)
            startActivity(intent)
        }
    }
    private fun initComponents() {

        comic?.let{
            Glide.with(this).load("${it.thumbnail?.path?.replace("http","https")}.${it.thumbnail?.extension}").into(binding.ivHqDetailBackgroud)
            Glide.with(this).load("${it.thumbnail?.path?.replace("http","https")}.${it.thumbnail?.extension}").into(binding.ivHqDetailCover)
            binding.tvHqDetailTitle.text = it.title
            binding.tvHqDetailDescription.text = it.description
            binding.tvHqDetailPagesNumber.text = it.pageCount.toString()

            binding.tvHqDetailPublishedDate.text = it.lDates?.get(0)?.toString()
            binding.tvHqDetailPriceValue.text = "S ${it.lPrices?.get(0)?.price}"

        }
    }


}