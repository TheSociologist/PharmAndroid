package com.example.pharmandroid.Models.Devices

import com.example.pharmandroid.Models.User.User
import com.example.pharmandroid.Models.Medication.Liquid
import com.example.pharmandroid.Models.Medication.Pill

class MicroDevice : Device() {
    override var _id: String? = null
    override var pills: Array<Pill?> = arrayOf(null)
    override var liquids: Array<Liquid?>? = null
    override var deviceUsers: List<User> = listOf()
    override var canLiquid: Boolean = true
}