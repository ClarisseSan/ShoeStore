package com.udacity.shoestore.view

import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.findNavController
import com.udacity.shoestore.R

import com.udacity.shoestore.placeholder.PlaceholderContent.PlaceholderItem
import com.udacity.shoestore.databinding.FragmentShoeObjectBinding

/**
 * [RecyclerView.Adapter] that can display a [PlaceholderItem].
 * TODO: Replace the implementation with code for your data type.
 */
class MyShoeRecyclerViewAdapter(
    private val values: List<PlaceholderItem>
) : RecyclerView.Adapter<MyShoeRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            FragmentShoeObjectBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.idView.text = item.id
        holder.contentView.text = item.content

    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(binding: FragmentShoeObjectBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val idView: TextView = binding.itemNumber
        val contentView: TextView = binding.content
        val itemView = binding.root

        init {
            itemView.setOnClickListener {
                itemView.findNavController().navigate(R.id.action_shoeList_to_shoeDetailFragment)
            }
        }

        override fun toString(): String {
            return super.toString() + " '" + contentView.text + "'"
        }

    }

}