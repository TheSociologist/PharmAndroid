package com.example.pharmandroid.Models.Devices

import com.example.pharmandroid.Models.User.User
import com.example.pharmandroid.Models.Medication.Liquid
import com.example.pharmandroid.Models.Medication.Pill

abstract class DeviceBase {
    abstract var _id: String?
    abstract var pills: Array<Pill?>
    abstract var liquids: Array<Liquid?>?
    abstract var deviceUsers: List<User>
    abstract var canLiquid: Boolean
}
