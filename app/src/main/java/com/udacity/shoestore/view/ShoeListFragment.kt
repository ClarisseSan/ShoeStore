package com.udacity.shoestore.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.viewmodel.ShoeViewModel

/**
 * A fragment representing a list of Items.
 */
class ShoeListFragment : Fragment() {

    private var columnCount = 1

    private val viewModel: ShoeViewModel by activityViewModels()

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

        // Set the viewmodel for databinding - this allows the bound layout access to all of the data in the VieWModel
        binding.shoeListViewModel = viewModel

        // Specify the current activity as the lifecycle owner of the binding. This is used so that the binding can observe LiveData updates
        binding.setLifecycleOwner(viewLifecycleOwner)



        //TODO observe change in shoeList
        viewModel.shoeList.observe(viewLifecycleOwner, Observer {
            // Set the adapter
            binding.recyclerView.adapter = ShoeRecyclerViewAdapter(viewModel.shoeList)
            ShoeRecyclerViewAdapter(viewModel.shoeList).notifyDataSetChanged()

        })


        //Add floating action button
        binding.fab.setOnClickListener {
            requireView().findNavController().navigate(R.id.action_shoeList_to_shoeDetailFragment)
        }



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