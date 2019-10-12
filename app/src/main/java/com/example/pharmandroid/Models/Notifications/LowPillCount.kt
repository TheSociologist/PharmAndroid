package com.example.pharmandroid.Models.Notifications

class LowPillCount : Notification {
    constructor(name: String, num: Int) {
        this.name = name
        this.num = num
    }

    constructor()

    override var name: String = ""
    var num: Int = 0
}
