package com.udacity.shoestore.view

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeListSimpleBinding
import com.udacity.shoestore.databinding.FragmentShoeObjectBinding
import com.udacity.shoestore.viewmodel.ShoeViewModel
import timber.log.Timber

/**
 * A fragment representing a list of Items.
 */
class ShoeListFragment : Fragment() {

    private val viewModel: ShoeViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate view and obtain an instance of the binding class
        val binding = FragmentShoeListSimpleBinding.inflate(inflater, container, false)

        // Set the viewmodel for databinding - this allows the bound layout access to all of the data in the VieWModel
        binding.shoeListViewModel = viewModel

        // Specify the current activity as the lifecycle owner of the binding. This is used so that the binding can observe LiveData updates
        binding.setLifecycleOwner(viewLifecycleOwner)


        //observe change in shoeList
        viewModel.shoeList.observe(viewLifecycleOwner, Observer {

            for (shoe in viewModel.shoeList.value!!) {
                val itemBinding = FragmentShoeObjectBinding.inflate(layoutInflater)
                itemBinding.shoeItem = shoe
                itemBinding.shoesizeText.text = shoe.size.toString()
                Timber.tag("Observer").i(shoe.name)
                binding.listLayout.addView(itemBinding.root)
            }


        })


        //Add floating action button
        binding.fab.setOnClickListener {
            view?.findNavController()
                ?.navigate(ShoeListFragmentDirections.actionShoeListToShoeDetailFragment())
        }


        //show options menu
        setHasOptionsMenu(true)

        return binding.root
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.logout_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.item_logout -> findNavController().navigate(ShoeListFragmentDirections.actionShoeListToLoginFragment())
        }
        return super.onOptionsItemSelected(item)
    }
}