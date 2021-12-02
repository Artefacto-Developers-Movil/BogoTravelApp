package com.bogotravel.bogotravel.main

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.ListFragment
import com.bogotravel.bogotravel.R
import com.bogotravel.bogotravel.preferences.SettingsFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.bottom_nav_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        val fm : FragmentManager = supportFragmentManager
        val ft : FragmentTransaction = fm.beginTransaction()

        return when (item.itemId){
            R.id.navigation_preference -> {
                val settingsFragment = SettingsFragment()
                ft.replace(R.id.fragmentContainerView, settingsFragment).commit()
                ft.addToBackStack(null)
                true
            }

            R.id.navigation_list -> {
                val listFragment = ListFragment()
                ft.replace(R.id.fragmentContainerView, listFragment).commit()
                ft.addToBackStack(null)
                true
            }

        android.R.id.home -> {
            onBackPressed()
            true
        }

          else -> {return true}

        }
    }
    fun showIcon(){
        val actionBar : ActionBar? = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)
    }

    fun hideIcon(){
        val actionBar : ActionBar? = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(false)
    }
}

