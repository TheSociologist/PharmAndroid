package com.example.pharmandroid.Models.Medication

import android.util.Log
import com.example.pharmandroid.Models.Medication.Medication

class Liquid : Medication() {
    override var dose: Double = 0.0
    override var total: Double = 0.0


    override fun dispense(dose: Int) {
        total -= dose
        Log.d("Dispensing", "Liquid $dose")

    }

    override fun dispense() {
        total -= dose
        Log.d("Dispensing", "Liquid")

    }

}