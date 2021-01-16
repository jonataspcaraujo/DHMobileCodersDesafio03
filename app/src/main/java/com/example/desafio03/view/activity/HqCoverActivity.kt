package com.example.desafio03.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.desafio03.databinding.ActivityHqCoverBinding

class HqCoverActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHqCoverBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHqCoverBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}