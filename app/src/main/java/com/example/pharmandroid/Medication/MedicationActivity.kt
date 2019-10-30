package com.example.pharmandroid.Medication

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.pharmandroid.Dashboard.DashboardActivity
import com.example.pharmandroid.Dashboard.DashboardFragment
import com.example.pharmandroid.Manage.ManageActivity
import com.example.pharmandroid.Manage.ManageFragment
import com.example.pharmandroid.Models.Medication.Inhalant
import com.example.pharmandroid.Models.Medication.Liquid
import com.example.pharmandroid.Models.Medication.Medication
import com.example.pharmandroid.Models.Medication.Pill
import com.example.pharmandroid.R
import com.google.android.material.bottomnavigation.BottomNavigationView


class MedicationActivity : AppCompatActivity(),
    MedicationListFragment.OnListFragmentInteractionListener,
    PillDetailFragment.OnFragmentInteractionListener,
    InhalantDetailFragment.OnFragmentInteractionListener,
    LiquidDetailFragment.OnFragmentInteractionListener {

    private var internalFrag = false
    override fun onFragmentInteraction(uri: Uri) {}

    override fun onListFragmentInteraction(item: Medication) {
        val fragment: Fragment = when (item) {
            is Pill -> PillDetailFragment.newInstance(item)
            is Liquid -> LiquidDetailFragment.newInstance(item)
            is Inhalant -> InhalantDetailFragment.newInstance(item)
            else -> {
                throw Exception("Not a type of medication")
            }
        }
        internalFrag = true
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, fragment, fragment.javaClass.simpleName)
            .commit()
    }

    private val onNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_medList -> {
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_dashboard -> {
                    val intent = Intent(this, DashboardActivity::class.java)
                    startActivity(intent)
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

    override fun onBackPressed() {
        Log.d("working", "working")
        if (internalFrag) {
            val fragment = MedicationListFragment()
            internalFrag = false
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, fragment, "MY_FRAGMENT")
                .commit()
        } else {
            this.finishAffinity()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val title: TextView = findViewById(R.id.title)
        title.text = "Medications"
        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
        val fragment = MedicationListFragment()
        internalFrag = false
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, fragment, "MY_FRAGMENT")
            .commit()
    }

}
