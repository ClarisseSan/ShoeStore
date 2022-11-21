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
    private val shoe_6: Shoe = Shoe("Vara Pump", 39.5, "Ferregamo", "Hig pump heels")
    private val shoe_7: Shoe = Shoe("Triple S", 40.5, "Balenciaga", "In white and yellow heels")
    private val shoe_8: Shoe = Shoe("D-Connect", 42.5, "Adidas", "White mesh women sneaker")
    private val shoe_9: Shoe = Shoe("Dior Caro", 36.5, "Dior", "Women loafers in pink")
    private val shoe_10: Shoe =
        Shoe("Burberry Pump", 39.0, "Burberry", "Vintage check women's shoes")

    var shoeList = MutableLiveData<MutableList<Shoe>>()
    private lateinit var list: MutableList<Shoe>

    init {
        addShoe()

    }

    fun addShoe() {
        list = mutableListOf(
            shoe_1, shoe_2, shoe_3, shoe_4, shoe_5, shoe_6, shoe_7, shoe_8, shoe_9, shoe_10,
        )
        shoeList.value = list

        for (shoe in list) {
            Log.i("ShowViewModel", shoe.name)
        }
    }

    fun saveShoe(shoe: Shoe) {
        list.add(shoe)
    }
}