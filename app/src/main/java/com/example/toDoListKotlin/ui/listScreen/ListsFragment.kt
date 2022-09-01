package com.example.toDoListKotlin.ui.listScreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.toDoListKotlin.R
import com.example.toDoListKotlin.dto.ToDoList
import com.google.android.material.floatingactionbutton.FloatingActionButton


class ListsFragment : Fragment() {
    private lateinit var listsRecyclerView: RecyclerView
    private lateinit var adapter: ListsRecyclerViewAdapter

    private lateinit var btnAddList: FloatingActionButton

    private lateinit var listViewModel: ListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_lists, container, false)

        initiateViews(rootView)
        initiateRecyclerView()
        initiateViewModel();

        btnAddList.setOnClickListener {
            listViewModel.insertNewList()
        }

        return rootView
    }

    private fun initiateViewModel() {
        listViewModel = ListViewModel()

        val observer: Observer<ArrayList<ToDoList>> = Observer<ArrayList<ToDoList>> { toDoLists ->
            adapter.updateToDoLists(toDoLists)
        }

        listViewModel.toDoLists.observe(viewLifecycleOwner, observer)
    }

    private fun initiateViews(rootView: View) {
        listsRecyclerView = rootView.findViewById(R.id.fragment_lists_recycler_view)
        btnAddList = rootView.findViewById(R.id.fragment_lists_add_list_button)
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
