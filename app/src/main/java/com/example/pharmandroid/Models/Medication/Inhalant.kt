package com.example.pharmandroid.Models.Medication

import android.util.Log
import com.example.pharmandroid.Models.Medication.Medication

class Inhalant : Medication() {
    override var total: Double = 0.0
    override var dose: Double = 0.0
    override fun dispense() {
        Log.d("Dispensing", "Inhalant")
    }

    override fun dispense(dose: Int) {
        Log.d("Dispensing", "Inhalant $dose")

    }
}