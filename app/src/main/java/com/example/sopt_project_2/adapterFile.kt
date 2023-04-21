package com.example.sopt_project_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class RecyclerViewAdapter(private val context: Context, private val data: List<String>, private val imageUrls: List<String>) :
    RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.myitemfile, parent, false)
        return ViewHolder(view)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]
        val imageUrl = imageUrls[position]
        holder.text.text = item

        Glide.with(holder.itemView.context)
            .load(imageUrl)
            .placeholder(R.drawable.img)
            .into(holder.imageView)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val text: TextView = itemView.findViewById(R.id.text)
        val imageView: ImageView = itemView.findViewById(R.id.left_profile)
    }
}

class HeaderAdapter(var headerText: String) : RecyclerView.Adapter<HeaderAdapter.HeaderViewHolder>() {

    inner class HeaderViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val headerTitle: TextView = view.findViewById(R.id.headerTitle)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeaderViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.header_layout, parent, false)
        return HeaderViewHolder(view)
    }

    override fun onBindViewHolder(holder: HeaderViewHolder, position: Int) {
        holder.headerTitle.text = headerText
    }

    override fun getItemCount(): Int {
        return 1
    }
}
