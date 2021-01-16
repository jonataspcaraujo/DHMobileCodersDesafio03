package com.example.desafio03.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.LayoutInflater
import com.example.desafio03.databinding.ActivityLoginBinding
import com.example.desafio03.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()
        setupObservables(binding)
    }

    private fun setupObservables(binding: ActivityRegisterBinding) = with(binding) {
        btRegisterSave.setOnClickListener {
            //Pendente: incluir veriricacao de campos e regras de email e senha. verificar metodos do desafio 02
            val intent = Intent(this@RegisterActivity, MenuActivity::class.java)
            startActivity(intent)
        }
    }


}