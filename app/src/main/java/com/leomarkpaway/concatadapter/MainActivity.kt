package com.leomarkpaway.concatadapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var concatAdapter: ConcatAdapter
    private lateinit var firstLabelAdapter: LabelAdapter
    private lateinit var firstAdapter: FirstAdapter
    private lateinit var secondLabelAdapter: LabelAdapter
    private lateinit var secondAdapter: SecondAdapter
    private var isFirstSectionVisible = true
    private var isSecondSectionVisible = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        val toggleFirst: Button = findViewById(R.id.toggle_first_section)
        val toggleSecond: Button = findViewById(R.id.toggle_second_section)

        firstLabelAdapter = LabelAdapter("First Section")
        firstAdapter = FirstAdapter(listOf("Item 1", "Item 2", "Item 3"))

        secondLabelAdapter = LabelAdapter("Second Section")
        secondAdapter = SecondAdapter(listOf("Item A", "Item B", "Item C"))

        concatAdapter =
            ConcatAdapter(firstLabelAdapter, firstAdapter, secondLabelAdapter, secondAdapter)
        recyclerView.adapter = concatAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        toggleFirst.setOnClickListener {
            toggleFirstSection()
        }
        toggleSecond.setOnClickListener {
            toggleSecondSection()
        }

    }

    private fun toggleFirstSection() {
        if (isFirstSectionVisible) {
            concatAdapter.removeAdapter(firstLabelAdapter)
            concatAdapter.removeAdapter(firstAdapter)
        } else {
            concatAdapter.addAdapter(0, firstLabelAdapter)
            concatAdapter.addAdapter(1, firstAdapter)
        }
        isFirstSectionVisible = !isFirstSectionVisible
    }

    private fun toggleSecondSection() {
        if (isSecondSectionVisible) {
            concatAdapter.removeAdapter(secondLabelAdapter)
            concatAdapter.removeAdapter(secondAdapter)
        } else {
            val firstSectionCount = if (isFirstSectionVisible) 2 else 0
            concatAdapter.addAdapter(firstSectionCount, secondLabelAdapter)
            concatAdapter.addAdapter(firstSectionCount + 1, secondAdapter)
        }
        isSecondSectionVisible = !isSecondSectionVisible
    }

}