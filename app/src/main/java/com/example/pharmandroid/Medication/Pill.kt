package com.example.pharmandroid.Medication

import android.util.Log
import java.time.LocalDate

class Pill {
    var name: String
    var total: Int
    var dose: Int
    var Rx: Int?
    var NDC: Int?
    var Information: String?
    var Directions: String?
    var ActiveIngredients: List<String>?
    var InactiveIngredients: List<String>?
    var Mass: Int?
    var Week: Array<Boolean>
    var ExpiryDate: LocalDate?
    var PrescribedDate: LocalDate?

    init {
        name = ""
        total = 0
        dose = 0
        Rx = null
        NDC = null
        Information = null
        Directions = null
        ActiveIngredients = null
        InactiveIngredients = null
        Mass = null
        Week = arrayOf(false, false, false, false, false, false, false)
        ExpiryDate = null
        PrescribedDate = null
    }
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

        fun totalupdate() {
            this.total -= this.dose
        }
    }

    fun setExpiryDate(Day: Int, Month: Int, Year: Int){
        ExpiryDate = LocalDate.of(Year, Month, Day)
    }
    fun setPrescribedDate(Day: Int, Month: Int, Year: Int){
        PrescribedDate = LocalDate.of(Year, Month, Day)
    }
    fun setPrescribedDateNow(){
        PrescribedDate = LocalDate.now()
    }

    fun dispense(dose: Int){
        for ( i in 1..dose){
            Log.d("DISPENSING", i.toString())
        }
        total = total - dose
    }
}
