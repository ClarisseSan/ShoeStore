package com.udacity.shoestore.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.viewmodel.ShoeViewModel

/**
 * A fragment representing a list of Items.
 */
class ShoeListFragment : Fragment() {

    private var columnCount = 1

    private lateinit var viewModel: ShoeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            columnCount = it.getInt(ARG_COLUMN_COUNT)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate view and obtain an instance of the binding class
        val binding = FragmentShoeListBinding.inflate(inflater, container, false)

        //get the view model
        viewModel = ViewModelProvider(this).get(ShoeViewModel::class.java)

        // Set the viewmodel for databinding - this allows the bound layout access to all of the data in the VieWModel
        binding.shoeListViewModel = viewModel

        // Specify the current activity as the lifecycle owner of the binding. This is used so that the binding can observe LiveData updates
        binding.setLifecycleOwner(viewLifecycleOwner)

        // Set the adapter
        val adapter = ShoeRecyclerViewAdapter(viewModel.shoeList)
        binding.recyclerView.adapter = adapter

        //observe



        return binding.root
    }

    companion object {

        // TODO: Customize parameter argument names
        const val ARG_COLUMN_COUNT = "column-count"

        // TODO: Customize parameter initialization
        @JvmStatic
        fun newInstance(columnCount: Int) =
            ShoeListFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_COLUMN_COUNT, columnCount)
                }
            }
    }
}