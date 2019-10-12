package com.example.pharmandroid.Dashboard

import com.example.pharmandroid.Models.Medication.Inhalant
import com.example.pharmandroid.Models.Medication.Pill
import com.example.pharmandroid.Models.Notifications.LowPillCount

object NotificationList {
    var LowPillCount: MutableList<LowPillCount> = mutableListOf()

    fun add(pill: LowPillCount) {
        LowPillCount.add(pill)
    }

    fun removeAll() {
        LowPillCount = mutableListOf()
    }

}