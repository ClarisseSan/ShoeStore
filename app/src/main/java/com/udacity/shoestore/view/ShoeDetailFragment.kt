package com.udacity.shoestore.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.udacity.shoestore.data.model.Shoe
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.viewmodel.ShoeViewModel

class ShoeDetailFragment : Fragment() {

    private var _binding: FragmentShoeDetailBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val viewModel: ShoeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate view and obtain an instance of the binding class
        _binding = FragmentShoeDetailBinding.inflate(inflater, container, false)

        // Set the viewmodel for databinding - this allows the bound layout access to all of the data in the VieWModel
        //binding.shoeViewModel = viewModel

        // Specify the current activity as the lifecycle owner of the binding. This is used so that the binding can observe LiveData updates
        binding.setLifecycleOwner(this)

        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var cancelButton: Button = binding.cancelButton
        var saveButton: Button = binding.saveButton
        var shoeNameText: TextView = binding.shoenameText
        var company: TextView = binding.companyText
        var shoeSize: TextView = binding.shoesizeText
        var description: TextView = binding.descriptionText

        saveButton.setOnClickListener {


            viewModel.saveShoe(
                Shoe(
                    shoeNameText.text.toString(),
                    viewModel.getSize(shoeSize.text.toString()),
                    company.text.toString(),
                    description.text.toString()
                )
            )

            //go back to Shoe List
            view.findNavController().navigate(ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeList())
        }



        cancelButton.setOnClickListener {
            view.findNavController()
                .navigate(ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeList())
        }
    }


}