package com.leomarkpaway.concatadapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)

        val firstAdapter = FirstAdapter(listOf("Item 1", "Item 2", "Item 3"))
        val secondAdapter = SecondAdapter(listOf("Item A", "Item B", "Item C"))

        val concatAdapter = ConcatAdapter(firstAdapter, secondAdapter)
        recyclerView.adapter = concatAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)

    }
}