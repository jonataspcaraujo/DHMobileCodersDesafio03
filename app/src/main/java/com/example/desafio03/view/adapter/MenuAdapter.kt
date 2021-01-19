package com.example.desafio03.view.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.desafio03.model.Result
import com.example.desafio03.model.Thumbnail
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.desafio03.databinding.RvItemComicBinding

class MenuAdapter(
        private val comicList: List<Result>,
        private val comicOnClicked: (Result) -> Unit
) : RecyclerView.Adapter<MenuAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = RvItemComicBinding.inflate(layoutInflater,parent,false)
//        val binding = RvItemHqBinding.inflate(layoutInflater, parent, false)
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
            val issueNumber = comic.issueNumber.toString()
            tvRvItemHqId.text = "#$issueNumber"

            itemView.setOnClickListener {
                comicOnClicked(comic)
            }

        }// end of fun bind


    }// end of class ViewHolder

}// end of class MenuAdapter