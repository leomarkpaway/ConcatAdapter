package com.leomarkpaway.concatadapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FirstAdapter(private val data: List<String>) :
    RecyclerView.Adapter<FirstAdapter.FirstViewHolder>() {
    class FirstViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView: TextView = itemView.findViewById(R.id.textView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FirstViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_first, parent, false)
        return FirstViewHolder(view)
    }

    override fun onBindViewHolder(holder: FirstViewHolder, position: Int) {
        holder.textView.text = data[position]
    }

    override fun getItemCount(): Int = data.size
}

