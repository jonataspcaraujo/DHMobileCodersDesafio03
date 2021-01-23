package com.example.desafio03.view.adapter

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import com.example.desafio03.model.Result
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.desafio03.databinding.RvItemComicBinding
import com.example.desafio03.util.Constants
import com.example.desafio03.view.activity.ComicDetailActivity
import com.example.desafio03.view.activity.MenuActivity


class MenuAdapter(
        private val comicList: List<Result>,
        private val comicOnClicked: (Result) -> Unit
) : RecyclerView.Adapter<MenuAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = RvItemComicBinding.inflate(layoutInflater,parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(comic = comicList[position], comicOnClicked)
    }

    override fun getItemCount(): Int {
        return comicList.size
    }

    class ViewHolder( private val binding:RvItemComicBinding):RecyclerView.ViewHolder(binding.root){

       @SuppressLint("SetTextI18n")
        fun bind(comic:Result, comicOnClicked: (Result) -> Unit) = with(binding){
            Glide.with(itemView.context)
                    .load("${comic.thumbnail?.path?.replace("http","https")}.${comic.thumbnail?.extension}")
                    .into(ivRvItemHq)

            val issueNumber = comic.issueNumber?.toInt().toString()
            tvRvItemHqId.text = "#$issueNumber"

           itemView.setOnClickListener {
               comicOnClicked(comic)
           }

        } // end of fun bind

    }// end of class ViewHolder

}// end of class MenuAdapter