package com.example.desafio03.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.desafio03.R
import com.example.desafio03.databinding.ActivityHqDetailBinding
import com.example.desafio03.databinding.ActivityMenuBinding

class HqDetailActivity : AppCompatActivity() {
    private lateinit var binding:ActivityHqDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHqDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupObservables(binding)
    }
    private fun setupObservables(binding: ActivityHqDetailBinding) {

    }
}