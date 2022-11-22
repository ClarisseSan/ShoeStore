package com.udacity.shoestore.data.model

import android.os.Parcelable
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import kotlinx.android.parcel.Parcelize

//@Parcelize
//data class Shoe(var name: String, var size: Double, var company: String, var description: String, val images: List<String> = mutableListOf()) : Parcelable

@Parcelize
data class Shoe(var name: String, var size: Double, var company: String, var description: String) : Parcelable
