package com.example.pharmandroid.Utils.Models

import com.example.pharmandroid.Models.Medication.Liquid
import com.example.pharmandroid.Models.Medication.Pill


data class Device(
    var _id: String?,
    var type: String?,
    var pills: Array<Pill>,
    var liquids: Array<Liquid>,
    var ownerUser: String,
    var subUsers: Array<User>,
    var batteryNote: Boolean,
    var lowPillCount: Boolean

)