package com.example.pharmandroid.Medication

object MedicationList {
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

    fun removePill(pill: Pill) {
        PillList.remove(pill)
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