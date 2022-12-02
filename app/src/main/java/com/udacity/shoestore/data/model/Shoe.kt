/**https://developer.android.com/topic/libraries/data-binding/two-way
In order to react to changes in the backing data, you can make your layout variable an implementation of Observable,
usually BaseObservable, and use a @Bindable annotation
 **/


package com.udacity.shoestore.data.model

import android.os.Parcelable
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import kotlinx.android.parcel.Parcelize

//@Parcelize
//data class Shoe(var name: String, var size: Double, var company: String, var description: String, val images: List<String> = mutableListOf()) : Parcelable


@Parcelize
data class Shoe(
    private var name: String,
    private var size: Double,
    private var company: String,
    private var description: String
) : Parcelable,
    BaseObservable() {

    @Bindable
    fun getName(): String {
        return name
    }

    fun setName(n: String) {
        name = n
    }

    @Bindable
    fun getSize(): String {
        return size.toString()
    }

    fun setSize(s: String) {
        size = s.toDouble()
    }

    @Bindable
    fun getCompany(): String {
        return company
    }

    fun setCompany(c: String) {
        company = c
    }


    @Bindable
    fun getDescription(): String {
        return description
    }

    fun setDescription(d: String) {
        description = d
    }


}
