package com.udacity.shoestore

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding

class ShoeDetailFragment : Fragment() {

    private var _binding : FragmentShoeDetailBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!


    companion object {
        fun newInstance() = ShoeDetailFragment()
    }

    private lateinit var viewModel: ShoeDetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding =  FragmentShoeDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var cancelButton : Button = binding.cancelButton
        var saveButton : Button = binding.saveButton

        saveButton.setOnClickListener {
            //TODO save shoe in LiveData
            view.findNavController().navigate(R.id.action_shoeDetailFragment_to_shoeList)
        }

        cancelButton.setOnClickListener {
            view.findNavController().navigate(R.id.action_shoeDetailFragment_to_shoeList)
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ShoeDetailViewModel::class.java)
        // TODO: Use the ViewModel
    }

}