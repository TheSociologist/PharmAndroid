package com.example.pharmandroid.Medication

import com.example.pharmandroid.Models.Medication.Inhalant
import com.example.pharmandroid.Models.Medication.Pill

object MasterMedicationList {
    val PillList: MutableList<Pill>
    val LiquidList: MutableList<Inhalant>
    val InhalantList: MutableList<Inhalant>

    init {
        PillList = mutableListOf()
        LiquidList = mutableListOf()
        InhalantList = mutableListOf()
    }

    fun addPill(pill: Pill) {
        PillList.add(pill)
    }

    fun addPill(pilllist: List<Pill>) {
        for (pill in pilllist) {
            PillList.add(pill)
        }
    }

    fun removePill(pill: Pill) {
        PillList.remove(pill)
    }

    fun removePill(pilllist: List<Pill>) {
        for (pill in pilllist) {
            PillList.remove(pill)
        }
    }

    fun removePills() {
        PillList.clear()
    }

    fun removeLiquids() {
        PillList.clear()
    }

    fun removeInhalants() {
        InhalantList.clear()
    }

    fun removeAll() {
        PillList.clear()
        LiquidList.clear()
        InhalantList.clear()
    }
}