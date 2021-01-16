package com.example.desafio03.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.desafio03.databinding.ActivityLoginBinding


class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()
        setupObservables(binding)

    }

    private fun setupObservables(binding: ActivityLoginBinding) = with(binding) {
        btLoginLogIn.setOnClickListener {
             //Pendente: incluir veriricacao de campos e regras de email e senha. verificar metodos do desafio 02
//            val intent = Intent(this@LoginActivity, MenuActivity::class.java)
//            startActivity(intent)
        }
        btLoginRegister.setOnClickListener {
            val intent = Intent(this@LoginActivity, RegisterActivity::class.java)
            startActivity(intent)
        }

    }

}