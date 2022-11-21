package com.udacity.shoestore.view

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.udacity.shoestore.R
import com.udacity.shoestore.data.model.Shoe
import com.udacity.shoestore.databinding.FragmentShoeObjectBinding

class ShoeRecyclerViewAdapter(
    private val data: LiveData<MutableList<Shoe>>
) : RecyclerView.Adapter<ShoeRecyclerViewAdapter.ViewHolder>() {

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
        val item = data.value!!.get(position)
        holder.apply {
            shoeName.text = item.name
            shoeCompany.text = item.company
            shoeSize.text = item.size.toString()
            shoeDescription.text = item.description
        }


    }

    override fun getItemCount(): Int = data.value!!.size

    inner class ViewHolder(binding: FragmentShoeObjectBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val shoeName: TextView = binding.shoenameText
        val shoeCompany: TextView = binding.shoenameCompany
        val shoeSize: TextView = binding.shoesizeText
        val shoeDescription: TextView = binding.shoedescriptionText

        init {
            itemView.setOnClickListener {
                itemView.findNavController().navigate(R.id.action_shoeList_to_shoeDetailFragment)
            }
        }


    }

}