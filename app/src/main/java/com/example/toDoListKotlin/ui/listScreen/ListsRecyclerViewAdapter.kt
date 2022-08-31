package com.example.toDoListKotlin.ui.listScreen

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.toDoListKotlin.R
import com.example.toDoListKotlin.dto.ToDoList
import com.example.toDoListKotlin.ui.handlers.ListClickHandler

class ListsRecyclerViewAdapter : RecyclerView.Adapter<ListsRecyclerViewAdapter.ViewHolder>() {
    var toDoLists: ArrayList<ToDoList> = ArrayList()

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var listNameView: TextView
        var listDescriptionView: TextView

        init {
            listNameView = itemView.findViewById(R.id.recycler_list_name)
            listDescriptionView = itemView.findViewById(R.id.recycler_list_description)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val rootView = inflater.inflate(R.layout.lists_recycler_view_item, parent, false)

        return ViewHolder(rootView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val list: ToDoList = toDoLists[position]

        holder.listNameView.text = list.header
        holder.listDescriptionView.text = list.description
    }

    override fun getItemCount(): Int {
        return toDoLists.size
    }
}