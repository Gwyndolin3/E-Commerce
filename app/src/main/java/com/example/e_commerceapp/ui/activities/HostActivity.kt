package com.example.e_commerceapp.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.e_commerceapp.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView


class HostActivity : AppCompatActivity() {


    lateinit var navController: NavController
    lateinit var bottomnavigationView: BottomNavigationView
    lateinit var appBarConfiguration: AppBarConfiguration




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_host)
        navController = findNavController(R.id.fragment)

        bottomnavigationView = findViewById(R.id.bottom_navigation_view)


        bottomnavigationView.setupWithNavController(navController)

val appBarConfiguration = AppBarConfiguration(setOf(
    R.id.homeFragment
     // When you make a fragment, add it here
    // Fragment 2
    // Fragment 3
    // Fragment 4
))



        setupActionBarWithNavController(navController,appBarConfiguration)





        }

    override fun onSupportNavigateUp(): Boolean {

        val navController = findNavController(R.id.fragment)
        return navController.navigateUp() || super.onSupportNavigateUp()
    }


}