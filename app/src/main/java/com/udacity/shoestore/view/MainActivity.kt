package com.udacity.shoestore.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.NavDestination
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

        //Change actionbar title
        navController.addOnDestinationChangedListener { nc: NavController, nd: NavDestination, bundle: Bundle? ->
            supportActionBar?.title =  when(nd.id){
                R.id.loginFragment -> "Login"
                R.id.welcomeFragment -> "Welcome"
                R.id.instructionFragment -> "Instructions"
                R.id.shoeDetailFragment -> "Add Shoe"
                R.id.shoeListFragment -> "Shoe List"
                else -> {""}
            }
        }

    }

    override fun onSupportNavigateUp(): Boolean {
        // Have the Activity handle the navigateUp action from our Activity
        val navController = this.findNavController(R.id.myNavHostFragment)
        return navController.navigateUp()
    }
}


