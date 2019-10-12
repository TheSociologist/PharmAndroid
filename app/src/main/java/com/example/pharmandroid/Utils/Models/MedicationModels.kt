package com.example.pharmandroid.Utils.Models

import java.time.LocalDate
import kotlin.collections.ArrayList

data class time(
    var hour: Int,
    var minute: Int
)


data class Medication(
    var type: String = "",
    var name: String = "",
    var time: MutableList<time>? = null,
    var missedPillTimelength: Int = 0,
    var doseWeek: BooleanArray = booleanArrayOf(false, false, false, false, false, false, false),
    var expirationDate: LocalDate = LocalDate.now(),
    var prescribedDate: LocalDate = LocalDate.now(),
    var activeIngredients: ArrayList<String> = arrayListOf(),
    var inactiveIngredients: ArrayList<String> = arrayListOf(),
    var description: String,
    var directions: String,
    var Rx: Int,
    var NDC: Int
)