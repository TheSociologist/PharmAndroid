package com.example.pharmandroid.Medication

import com.example.pharmandroid.Models.Medication.Liquid
import com.example.pharmandroid.Models.Medication.Pill

class MedicationList(val pillSize: Int, val liquidSize: Int) {
    var PillList = ArrayList<Pill?>()
    var LiquidList = ArrayList<Liquid?>()

    fun add(pill: Pill, slot: Int) {
        var index = slot + 1
        PillList[index] = pill
    }

    fun add(liquid: Liquid, slot: Int) {
        var index = slot + 1
        LiquidList[index] = liquid
    }

    fun removePill(slot: Int) {
        var index = slot + 1
        PillList[index] = null
    }

    fun removeLiquid(packet: Int) {
        var index = packet + 1
        LiquidList[index] = null
    }
}