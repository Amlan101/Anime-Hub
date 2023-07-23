package com.example.animehub.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.example.animehub.R
import com.example.animehub.databinding.ActivityMainBinding
import com.example.animehub.fragment.AboutAppFragment
import com.example.animehub.fragment.DashboardFragment
import com.example.animehub.fragment.FavouritesFragment
import com.example.animehub.fragment.ProfileFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var previousMenuItem: MenuItem? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //This line initializes the binding object which we will use to access Views in the activity_main.xml layout.
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        setUpToolbar()

        // This is to ensure that the first screen opened to be the Dashboard Fragment
        openFragment(DashboardFragment(), "Dashboard")
        binding.navigationView.setCheckedItem(R.id.dashboard)

        val actionBarDrawerToggle = ActionBarDrawerToggle(
            this@MainActivity,
            binding.drawerLayout,
            R.string.open_drawer,
            R.string.close_drawer
        )
        binding.drawerLayout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()

        //This code makes the menu on the Navigation View functional
        binding.navigationView.setNavigationItemSelectedListener{

            //This code is used for checking and unchecking of menu items
            if(previousMenuItem != null){
                previousMenuItem?.isChecked = false
            }

            it.isCheckable = true
            it.isChecked = true
            previousMenuItem = it

            // Code to be executed when any of the menu items on the navigation drawer have been clicked
            when(it.itemId){

                R.id.dashboard -> {
                    openFragment(DashboardFragment(), "Dashboard")
                }
                R.id.favourites -> {
                    openFragment(FavouritesFragment(), "Favourites")
                }
                R.id.profile -> {
                    openFragment(ProfileFragment(), "Profile")
                }
                R.id.about_app -> {
                    openFragment(AboutAppFragment(), "About App")
                }
            }
            return@setNavigationItemSelectedListener true
        }
    }

    private fun setUpToolbar(){
        setSupportActionBar(binding.toolbar)
        supportActionBar?.title = "Anime Hub"
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    // This function is basically a clickListener method for the HomeButton of the Action Bar
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        val id = item.itemId

        if(id == android.R.id.home){
            binding.drawerLayout.openDrawer(GravityCompat.START)
        }

        return super.onOptionsItemSelected(item)
    }

    // This function takes up the functionalities of addToBackStack
    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        val fragment = supportFragmentManager.findFragmentByTag(binding.frame.toString())

        when(fragment){
            !is DashboardFragment -> openFragment(DashboardFragment(), "Dashboard")

            else -> super.onBackPressed()
        }
    }

    // This helper function inflates the fragment
    private fun openFragment(fragment: Fragment, fragmentName: String) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frame, fragment)
//            .addToBackStack(fragmentName) --> This action is being performed by the function onBackPressed()
        transaction.commit()
        supportActionBar?.title = fragmentName
        //This line is used to close the drawer after the fragment has been inflated
        binding.drawerLayout.closeDrawers()
    }
}