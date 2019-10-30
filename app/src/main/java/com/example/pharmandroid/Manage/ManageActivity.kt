package com.example.pharmandroid.Manage

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.example.pharmandroid.Dashboard.DashboardActivity
import com.example.pharmandroid.Dashboard.DashboardFragment
import com.example.pharmandroid.Medication.MedicationActivity
import com.example.pharmandroid.Medication.MedicationListFragment
import com.example.pharmandroid.R
import com.google.android.material.bottomnavigation.BottomNavigationView


class ManageActivity : AppCompatActivity(),
    ManageFragment.OnListFragmentInteractionListener,
    UserDetailFragment.OnFragmentInteractionListener {

    override fun onFragmentInteraction(uri: Uri) {}

    private val onNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_medList -> {
                    val intent = Intent(this, MedicationActivity::class.java)
                    startActivity(intent)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_dashboard -> {
                    val intent = Intent(this, DashboardActivity::class.java)
                    startActivity(intent)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_manage -> {
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val title: TextView = findViewById<TextView>(R.id.title)
        title.text = "Family"
        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
        navView.menu.getItem(2).isChecked = true
        val fragment = ManageFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, fragment, fragment.javaClass.simpleName)
            .commit()

    }

}
