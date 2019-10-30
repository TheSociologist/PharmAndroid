package com.example.pharmandroid.Medication

import com.example.pharmandroid.Models.Medication.Inhalant
import com.example.pharmandroid.Models.Medication.Liquid
import com.example.pharmandroid.Models.Medication.Medication
import com.example.pharmandroid.Models.Medication.Pill

object MedicationList {
    val CompleteList: MutableList<Medication> = mutableListOf()

    fun add(pill: Pill) {
        if (CompleteList.contains(pill)) return
        CompleteList.add(pill)
    }

    fun add(liquid: Liquid) {
        if (CompleteList.contains(liquid)) return
        CompleteList.add(liquid)

    }

    fun add(inhalant: Inhalant) {
        if (CompleteList.contains(inhalant)) return
        CompleteList.add(inhalant)

    }

    fun remove(pill: Pill) {
        if (CompleteList.contains(pill)) return
        CompleteList.remove(pill)
    }

    fun remove(liquid: Liquid) {
        if (CompleteList.contains(liquid)) return
        CompleteList.remove(liquid)
    }

    fun remove(inhalant: Inhalant) {
        if (CompleteList.contains(inhalant)) return
        CompleteList.remove(inhalant)
    }

    fun clear() {
        CompleteList.clear()
    }
}