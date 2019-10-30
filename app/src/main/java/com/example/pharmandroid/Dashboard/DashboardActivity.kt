package com.example.pharmandroid.Dashboard

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.example.pharmandroid.Manage.ManageActivity
import com.example.pharmandroid.Medication.MedicationActivity
import com.example.pharmandroid.Medication.MedicationListFragment
import com.example.pharmandroid.Models.Notifications.LowPillCount
import com.example.pharmandroid.R
import com.google.android.material.bottomnavigation.BottomNavigationView


class DashboardActivity : AppCompatActivity(),
    NotificationDetailFragment.OnFragmentInteractionListener,
    DashboardFragment.OnListFragmentInteractionListener {


    override fun onListFragmentInteraction(item: LowPillCount) {
        val fragment = NotificationDetailFragment.newInstance(item)
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, fragment, fragment.javaClass.simpleName)
            .commit()
    }

    private val onNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_medList -> {
                    val intent = Intent(this, MedicationActivity::class.java)
                    startActivity(intent)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_dashboard -> {
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_manage -> {
                    val intent = Intent(this, ManageActivity::class.java)
                    startActivity(intent)
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        }

    override fun onFragmentInteraction(uri: Uri) {}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val title: TextView = findViewById<TextView>(R.id.title)
        title.text = "Dashboard"
        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
        navView.menu.getItem(1).isChecked = true
        val fragment = DashboardFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, fragment, fragment.javaClass.simpleName)
            .commit()

    }

}
