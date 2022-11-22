package com.udacity.shoestore.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.ActivityMainBinding
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        Timber.plant(Timber.DebugTree())

        setSupportActionBar(binding.toolbar)

        //Setup the nav controller with the toolbar and an AppBarConfiguration
        //find Navigation Controller
        val navController = this.findNavController(R.id.myNavHostFragment)

        //Link navcontroller with action bar
        NavigationUI.setupActionBarWithNavController(this, navController)

    }

    override fun onSupportNavigateUp(): Boolean {
        // Have the Activity handle the navigateUp action from our Activity
        val navController = this.findNavController(R.id.myNavHostFragment)
        return navController.navigateUp()
    }
}
