package com.example.pharmandroid.Utils.Models

import com.example.pharmandroid.Utils.Models.Device
import com.example.pharmandroid.Utils.Models.Medication
import java.time.LocalDate

data class User(
    var type: String = "",
    var email: String = "",
    var firstName: String = "",
    var lastName: String = "",
    var phoneNumber: Int = 0,
    var birthDate: LocalDate = LocalDate.now(),
    var city: String = "",
    var state: String = "",
    var areaCode: String = "",
    var devices: ArrayList<Device> = arrayListOf(),
    var deviceMedications: ArrayList<Int> = arrayListOf(),
    var personalMedications: ArrayList<Medication> = arrayListOf(),
    var iphone: Boolean = false,
    var android: Boolean = false,
    var windows: Boolean = false,
    var apple: Boolean = false
)