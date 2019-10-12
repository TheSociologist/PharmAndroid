package com.example.pharmandroid

import android.app.Notification
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import android.net.Uri
import com.example.pharmandroid.Dashboard.DashboardFragment
import com.example.pharmandroid.Dashboard.NotificationDetailFragment
import com.example.pharmandroid.Manage.ManageFragment
import com.example.pharmandroid.Manage.UserDetailFragment
import com.example.pharmandroid.Medication.MedicationListFragment
import com.example.pharmandroid.Models.Medication.Pill
import com.example.pharmandroid.Medication.PillDetailFragment
import com.example.pharmandroid.Models.Notifications.LowPillCount
import com.example.pharmandroid.Models.User.User


class MainActivity : AppCompatActivity(), MedicationListFragment.OnListFragmentInteractionListener,
    DashboardFragment.OnListFragmentInteractionListener, ManageFragment.OnListFragmentInteractionListener,
    PillDetailFragment.OnFragmentInteractionListener, UserDetailFragment.OnFragmentInteractionListener,
    NotificationDetailFragment.OnFragmentInteractionListener {

    override fun onListFragmentInteraction(item: Pill) {
        val fragment = PillDetailFragment.newInstance(item)
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, fragment, fragment.javaClass.simpleName)
            .commit()
    }

    override fun onListFragmentInteraction(item: LowPillCount) {
        val fragment = NotificationDetailFragment.newInstance(item)
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, fragment, fragment.javaClass.simpleName)
            .commit()
    }

    override fun onListFragmentInteraction(item: User) {
        val fragment = UserDetailFragment.newInstance(item)
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, fragment, fragment.javaClass.simpleName)
            .commit()
    }

    override fun onFragmentInteraction(uri: Uri) {}


    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_medList -> {
                val fragment = MedicationListFragment()
                supportFragmentManager.beginTransaction()
                    .replace(R.id.container, fragment, fragment.javaClass.simpleName)
                    .commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                val fragment = DashboardFragment()
                supportFragmentManager.beginTransaction()
                    .replace(R.id.container, fragment, fragment.javaClass.simpleName)
                    .commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_manage -> {
                val fragment = ManageFragment()
                supportFragmentManager.beginTransaction()
                    .replace(R.id.container, fragment, fragment.javaClass.simpleName)
                    .commit()
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
        if (savedInstanceState == null) {
            val fragment = MedicationListFragment()
            supportFragmentManager.beginTransaction().replace(R.id.container, fragment, fragment.javaClass.simpleName)
                .commit()
        }


    }
}
