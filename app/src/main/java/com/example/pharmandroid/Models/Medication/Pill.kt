package com.example.pharmandroid.Models.Medication

import android.util.Log
import com.example.pharmandroid.Models.Medication.Medication

class Pill : Medication() {
    override var total: Int = 0
    override var dose: Int = 0
    override val type = "pill"
    override var canDispense = true


    override fun dispense(dosage: Int) {
        total -= dose
        Log.d("Dispensing", "Pill $dose")

    }

    override fun dispense() {
        total -= dose
        Log.d("Dispensing", "Pill")

    }
}
