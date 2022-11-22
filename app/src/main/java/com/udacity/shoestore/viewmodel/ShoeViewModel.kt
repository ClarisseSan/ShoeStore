package com.udacity.shoestore.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.data.model.Shoe

class ShoeViewModel : ViewModel() {

    //shoe name
    private val _shoename = MutableLiveData<String>()
    val shoename: LiveData<String>
        get() = _shoename

    //company
    private val _company = MutableLiveData<String>()
    val company: LiveData<String>
        get() = _company

    //shoe size
    private val _shoesize = MutableLiveData<String>()
    val shoesize: LiveData<String>
        get() = _shoesize

    //description
    private val _description = MutableLiveData<String>()
    val description: LiveData<String>
        get() = _description

    private val shoe_1: Shoe = Shoe("Chuck Taylor", 37.5, "Converse", "Black high heeled shoes")
    private val shoe_2: Shoe = Shoe("Star Hike", 36.0, "Converse", "Black high heeled shoes")
    private val shoe_3: Shoe = Shoe("Classic", 33.5, "New Balance", "Black high heeled shoes")
    private val shoe_4: Shoe = Shoe("Gizeh Eva", 41.5, "Birkenstock", "Pink with white heels shoes")
    private val shoe_5: Shoe = Shoe("Gucci Gigi", 48.0, "Gucci", "Black high heeled shoes")

    private var _shoeList = MutableLiveData<MutableList<Shoe>>()
    val shoeList: LiveData<MutableList<Shoe>>
        get() = _shoeList

    // save state of the Shoe
    private var _saveState = MutableLiveData<Boolean>()
    val saveState: LiveData<Boolean>
        get() = _saveState

    init {
        getShoesList()
        _saveState.value = false

        for (shoe in shoeList.value!!) {
            Log.i("init", shoe.name)
        }
    }

    private fun getShoesList(): MutableLiveData<MutableList<Shoe>> {
        _shoeList.value = mutableListOf()
        saveShoe(shoe_1)
        saveShoe(shoe_2)
        saveShoe(shoe_3)
        saveShoe(shoe_4)
        saveShoe(shoe_5)
        return _shoeList
    }

    fun saveShoe(shoe: Shoe) {

        //add shoe to list
        _shoeList.value?.add(shoe)

        for (shoe in shoeList.value!!) {
            Log.i("saveShoe", shoe.name)
        }
        _saveState.value = true

    }

    fun onEventSaveComplete() {
        _saveState.value = false
    }


}