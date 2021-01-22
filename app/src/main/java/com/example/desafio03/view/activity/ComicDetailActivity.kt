package com.example.desafio03.view.activity

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import com.bumptech.glide.Glide
import com.example.desafio03.R
import com.example.desafio03.databinding.ActivityComicDetailBinding
import com.example.desafio03.model.Result
import com.example.desafio03.util.Constants.Intent.KEY_COMIC_RESULT
import java.time.LocalDate
import java.time.format.DateTimeFormatter


class ComicDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityComicDetailBinding
    private var comic: Result? = null

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityComicDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        comic = intent.getParcelableExtra(KEY_COMIC_RESULT)
        setupComponents(comic)

    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun setupComponents(comic: Result?) {
        //Backgroud image comic
        comic?.lImages?.forEach {
            Glide.with(this)
                    .load(it.path)
                    .placeholder(R.drawable.marvel_background)
                    .into(binding.ivHqDetailBackgroud)
        }
        //Cover image comic
        Glide.with(this)
                .load(comic?.thumbnail?.path)
                .placeholder(R.drawable.raster)
                .into(binding.ivHqDetailCover)

        //Title comic
        binding.tvHqDetailTitle.text = comic?.title

        //Description comic
        if (comic?.description.isNullOrEmpty())
            binding.tvHqDetailDescription.text = comic?.description
        else
            binding.tvHqDetailDescription.text = "Descrição indisponível"

        //Publication date comic
        if (comic?.lDates?.get(0)?.type == "onsaleDate") {
            val date = comic?.lDates?.get(0)?.date
            val toDate = DateTimeFormatter.ofPattern("MM dd, yyyy")
            val dateFormatted = LocalDate.parse(date?.substring(0, 19), DateTimeFormatter.ISO_LOCAL_DATE_TIME)
            binding.tvHqDetailPublishedDate.text = toDate.format(dateFormatted)
        }

        //Price comic
        binding.tvHqDetailPriceValue.text = "$ ${comic?.lPrices?.get(0)?.price}"

        //Pages number's comic
        binding.tvHqDetailPagesNumber.text = comic?.pageCount.toString()
    }

}