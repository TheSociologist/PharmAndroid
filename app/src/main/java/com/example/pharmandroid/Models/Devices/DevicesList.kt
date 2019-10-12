package com.example.pharmandroid.Models.Devices

object DevicesList {
    var UltimateList: ArrayList<UltimateDevice> = arrayListOf()
    var StandardList: ArrayList<StandardDevice> = arrayListOf()
    var MiniList: ArrayList<MiniDevice> = arrayListOf()
    var MicroList: ArrayList<MicroDevice> = arrayListOf()

    fun remove(id: String): Boolean {
        var Device: Any?
        Device = UltimateList.find { it._id === id }
        if (Device !== null) {
            return UltimateList.remove(Device)
        }
        Device = StandardList.find { it._id === id }
        if (Device !== null) {
            return StandardList.remove(Device)
        }
        Device = MiniList.find { it._id === id }
        if (Device !== null) {
            return MiniList.remove(Device)
        }
        Device = MicroList.find { it._id === id }
        if (Device !== null) {
            return MicroList.remove(Device)
        }
        return false

    }
}