package com.example.desafio03.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.desafio03.databinding.ActivityMenuBinding
import com.example.desafio03.model.Result
import com.example.desafio03.util.Constants.Intent.KEY_COMIC_RESULT
import com.example.desafio03.view.adapter.MenuAdapter
import com.example.desafio03.viewmodel.MenuViewModel


class MenuActivity : AppCompatActivity() {

    private lateinit var viewModel: MenuViewModel
    private lateinit var binding: ActivityMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(MenuViewModel::class.java)
        viewModel.getComics()

        setupObservables(binding)
    }

//
    private fun setupObservables(binding: ActivityMenuBinding) {
        // Iniciando o menu de HQs, quando ha resultados na consulta API
        viewModel.onResultComics.observe(this,{
            it?.data?.let {
                //iniciando Recycle View
                setupRecycleView(it.results)
            }
        })// end of viewModel.onResultHqs.observe(...)ensagem de falha no carregamento dos dados, quando ocorre erro na consulta API
        viewModel.onResultFailure.observe(this,{
            Toast.makeText(this,it,Toast.LENGTH_LONG).show()
        })
    }

    private fun setupRecycleView(lComics: List<Result>){
        binding.rvMenuHQList.apply{
            layoutManager = GridLayoutManager(this@MenuActivity,3)
            adapter = MenuAdapter(this.context as MenuActivity,lComics){
                // adapter
                val intent = Intent(this@MenuActivity, ComicDetailActivity::class.java).apply {
                    putExtra(KEY_COMIC_RESULT,it)
                    startActivity(this)
                }
            }
        }// End Grid Layout

    }


}

