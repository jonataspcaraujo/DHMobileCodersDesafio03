package com.example.desafio03.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
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
            if (etLoginEmail.text.isNullOrEmpty() || etLoginPassword.text.isNullOrEmpty()) {
                Toast.makeText(this@LoginActivity, "Campos obrigatórios", LENGTH_LONG).show()
            } else if (!verificaEmail(etLoginEmail)) {
                Toast.makeText(this@LoginActivity, "Email Inválido", LENGTH_LONG).show()
            } else {
                val intent = Intent(this@LoginActivity, MenuActivity::class.java)
                startActivity(intent)
            }
        }

        btLoginRegister.setOnClickListener {
            val intent = Intent(this@LoginActivity, RegisterActivity::class.java)
            startActivity(intent)
        }
    }

    private fun verificaEmail(etLoginEmail: EditText): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(etLoginEmail.text).matches()
    }
}

