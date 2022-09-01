package com.example.toDoListKotlin.ui.listScreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.toDoListKotlin.R


class ListsFragment : Fragment() {
    private lateinit var listsRecyclerView: RecyclerView
    private lateinit var adapter: ListsRecyclerViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_lists, container, false)

        initiateViews(rootView)
        initiateRecyclerView()

        return rootView
    }

    private fun initiateViews(rootView: View) {
        listsRecyclerView = rootView.findViewById(R.id.fragment_lists_recycler_view)
    }

    private fun initiateRecyclerView() {
        adapter = ListsRecyclerViewAdapter()
        adapter.clickHandler = {
            Toast.makeText(context, "Clicked", Toast.LENGTH_SHORT).show()
        }
        listsRecyclerView.adapter = adapter
        listsRecyclerView.layoutManager = LinearLayoutManager(context)
    }
}
