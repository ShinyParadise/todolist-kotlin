package com.example.toDoListKotlin.ui.listScreen

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.toDoListKotlin.databinding.ListsRecyclerViewItemBinding
import com.example.toDoListKotlin.dto.ToDoList

class ListsRecyclerViewAdapter : RecyclerView.Adapter<ListsRecyclerViewAdapter.ViewHolder>() {
    var toDoLists: ArrayList<ToDoList> = ArrayList()
    var clickHandler: ((Int) -> Unit)? = null

    class ViewHolder(val binding: ListsRecyclerViewItemBinding): RecyclerView.ViewHolder(binding.root) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListsRecyclerViewItemBinding.inflate(inflater)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val list: ToDoList = toDoLists[position]
        holder.binding.list = list
        holder.binding.executePendingBindings()
    }

    override fun getItemCount(): Int {
        return toDoLists.size
    }

    fun updateToDoLists(toDoLists: ArrayList<ToDoList>) {
        this.toDoLists = toDoLists
        notifyDataSetChanged()
    }
}
