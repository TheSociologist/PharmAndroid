package com.example.pharmandroid.Models.User

import android.bluetooth.BluetoothClass
import com.example.pharmandroid.Models.Medication.Medication
import com.example.pharmandroid.Models.Medication.Pill
import com.example.pharmandroid.Models.Devices.DevicesList

class User {
    var firstName: String = ""
    var lastName: String = ""
    var email: String = ""
    var JWT: String? = null
    var address: String = ""
    var password = ""
    var android: Boolean = true
    var iPhone: Boolean = false
    var windows: Boolean = false
    var apple: Boolean = false
    var personalMedication: ArrayList<Pill> = arrayListOf()
    var deviceMedication: ArrayList<Pill> = arrayListOf()
}