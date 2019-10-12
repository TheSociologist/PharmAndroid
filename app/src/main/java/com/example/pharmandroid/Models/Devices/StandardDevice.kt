package com.example.pharmandroid.Models.Devices

import com.example.pharmandroid.Models.User.User
import com.example.pharmandroid.Models.Medication.Liquid
import com.example.pharmandroid.Models.Medication.Pill

class StandardDevice : DeviceBase() {
    override var _id: String? = null
    override var pills: Array<Pill?> =
        arrayOf(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null)
    override var liquids: Array<Liquid?>? = arrayOf(null, null)
    override var deviceUsers: List<User> = listOf()
    override var canLiquid: Boolean = true
}