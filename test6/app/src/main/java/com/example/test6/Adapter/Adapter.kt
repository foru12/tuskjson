package com.example.test6.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.test6.R
import com.squareup.picasso.Picasso


class Adapter : RecyclerView.Adapter<Adapter.MyViewHolder>() {

    private var urlList: List<String> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.layout_movies_item,parent,false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(urlList[position])
    }

    override fun getItemCount(): Int {
        return urlList.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val image:ImageView = itemView.findViewById(R.id.image)

        fun bind(imageUrl: String) {
            Picasso.get().load(imageUrl).fit().centerInside().into(image)
        }
    }

    fun setData(newUrlList: List<String>) {
        urlList = newUrlList
        notifyDataSetChanged()
    }
}