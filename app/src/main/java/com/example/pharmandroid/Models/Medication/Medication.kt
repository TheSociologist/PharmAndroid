package com.example.pharmandroid.Models.Medication

import android.util.Log
import java.time.LocalDate

abstract class Medication {
    abstract val total: Number
    abstract val dose: Number
    abstract val type: String

    open var canDispense: Boolean = false

    var name: String = ""
    var Rx: Int? = null
    var NDC: Int? = null
    var Information: String = ""
    var Directions: String = ""
    var ActiveIngredients: List<String>? = null
    var InactiveIngredients: List<String>? = null
    var Week: Array<Boolean> = arrayOf(false, false, false, false, false, false, false)
    var ExpiryDate: LocalDate = LocalDate.now()
    var PrescribedDate: LocalDate = LocalDate.now()

    fun addDay(varargs: String) {
        for (String in varargs){
            when (varargs) {
                "Monday" -> Week[0] = true
                "Tuesday" -> Week[1] = true
                "Wednesday" -> Week[2] = true
                "Thursday" -> Week[3] = true
                "Friday" -> Week[4] = true
                "Saturday" -> Week[5] = true
                "Sunday" -> Week[6] = true
                "All" -> for (i in 0..6){
                    Week[i] = false
                }
            }
        }

    }
    fun removeDay(varargs: String) {
        for (String in varargs){
            when (varargs) {
                "Monday" -> Week[0] = false
                "Tuesday" -> Week[1] = false
                "Wednesday" -> Week[2] = false
                "Thursday" -> Week[3] = false
                "Friday" -> Week[4] = false
                "Saturday" -> Week[5] = false
                "Sunday" -> Week[6] = false
                "All" -> for (i in 0..6){
                    Week[i] = false
                }
            }

        }


    }


    fun setExpiryDate(Day: Int, Month: Int, Year: Int){
        ExpiryDate = LocalDate.of(Year, Month, Day)
    }
    fun setPrescribedDate(Day: Int, Month: Int, Year: Int){
        PrescribedDate = LocalDate.of(Year, Month, Day)
    }

    abstract fun dispense(dose: Int)
    abstract fun dispense()
}