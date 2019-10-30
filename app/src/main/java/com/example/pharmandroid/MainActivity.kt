package com.example.pharmandroid

import android.content.Intent
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import android.net.Uri
import android.util.Log
import androidx.fragment.app.Fragment
import com.example.pharmandroid.Dashboard.DashboardFragment
import com.example.pharmandroid.Dashboard.NotificationDetailFragment
import com.example.pharmandroid.Manage.ManageFragment
import com.example.pharmandroid.Manage.UserDetailFragment
import com.example.pharmandroid.Medication.*
import com.example.pharmandroid.Models.Medication.Pill
import com.example.pharmandroid.Models.Medication.Inhalant
import com.example.pharmandroid.Models.Medication.Liquid
import com.example.pharmandroid.Models.Medication.Medication
import com.example.pharmandroid.Models.Notifications.LowPillCount
import com.example.pharmandroid.Models.User.User


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val intent = Intent(this, MedicationActivity::class.java)
        startActivity(intent)
    }
}
