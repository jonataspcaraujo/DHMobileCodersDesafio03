package com.example.desafio03.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Patterns.EMAIL_ADDRESS
import android.view.LayoutInflater
import android.widget.EditText
import android.widget.Toast
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
            if (binding.etRegisterName.text.isNullOrEmpty() ||
                    binding.etRegisterEmail.text.isNullOrEmpty() ||
                    binding.etRegisterPassword.text.isNullOrEmpty()){
                Toast.makeText(this@RegisterActivity, "Campos obrigatórios", Toast.LENGTH_LONG).show()
            }
            else if(!verificaEmail(binding.etRegisterEmail)) {
                Toast.makeText(this@RegisterActivity, "Email Inválido", Toast.LENGTH_LONG).show()
            }else {
                val intent = Intent(this@RegisterActivity, MenuActivity::class.java)
                startActivity(intent)
            }
        }
    }

    private fun verificaEmail(etLoginEmail: EditText): Boolean {
        return EMAIL_ADDRESS.matcher(etLoginEmail.text).matches()
    }

}