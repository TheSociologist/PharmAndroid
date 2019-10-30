package com.example.pharmandroid.Medication

import android.app.DatePickerDialog
import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.pharmandroid.R
import kotlinx.android.synthetic.main.fragment_liquid_detail.view.*
import android.widget.DatePicker

import android.icu.text.SimpleDateFormat
import android.icu.util.Calendar
import android.widget.Button
import com.example.pharmandroid.Models.Medication.Liquid
import java.util.*

private var ARG_PARAM1: Liquid =
    Liquid()

class LiquidDetailFragment : Fragment() {
    lateinit var preDate: Button
    lateinit var expDate: Button

    private var liquid: Liquid =
        Liquid()
    private var listener: OnFragmentInteractionListener? = null

    var precal = Calendar.getInstance()
    var expcal = Calendar.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            liquid = ARG_PARAM1
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_liquid_detail, container, false)
        view.liquidName.setText(liquid.name)
        view.liquidTotal.setText(liquid.total.toString())
        view.liquidDose.setText(liquid.dose.toString())
        view.liquidInfo.setText(liquid.Information)
        view.liquidExpired.text =
            "${liquid.ExpiryDate.dayOfMonth}/${liquid.ExpiryDate.month}/${liquid.ExpiryDate.year}"
        view.liquidPrescribed.text =
            "${liquid.PrescribedDate.dayOfMonth}/${liquid.PrescribedDate.month}/${liquid.PrescribedDate.year}"

        expDate = view.liquidExpired
        preDate = view.liquidPrescribed

        val prescribeddateSetListener = object : DatePickerDialog.OnDateSetListener {
            override fun onDateSet(
                view: DatePicker, year: Int, monthOfYear: Int,
                dayOfMonth: Int
            ) {
                precal.set(Calendar.YEAR, year)
                precal.set(Calendar.MONTH, monthOfYear)
                precal.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                prescribedupdateDateInView()
            }
        }
        val expireddateSetListener = object : DatePickerDialog.OnDateSetListener {
            override fun onDateSet(
                view: DatePicker, year: Int, monthOfYear: Int,
                dayOfMonth: Int
            ) {
                expcal.set(Calendar.YEAR, year)
                expcal.set(Calendar.MONTH, monthOfYear)
                expcal.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                expiredupdateDateInView()
            }
        }

        expDate.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View) {
                DatePickerDialog(
                    context!!,
                    expireddateSetListener,
                    // set DatePickerDialog to point to today's date when it loads up
                    expcal.get(Calendar.YEAR),
                    expcal.get(Calendar.MONTH),
                    expcal.get(Calendar.DAY_OF_MONTH)
                ).show()
            }
        })
        preDate.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View) {
                DatePickerDialog(
                    context!!,
                    prescribeddateSetListener,
                    precal.get(Calendar.YEAR),
                    precal.get(Calendar.MONTH),
                    precal.get(Calendar.DAY_OF_MONTH)
                    // set DatePickerDialog to point to today's date when it loads up
                ).show()
            }
        })

        return view
    }

    private fun prescribedupdateDateInView() {
        val myFormat = "MM/dd/yyyy" // mention the format you need
        val sdf = SimpleDateFormat(myFormat, Locale.US)
        preDate.text = sdf.format(precal.time)
    }

    private fun expiredupdateDateInView() {
        val myFormat = "MM/dd/yyyy" // mention the format you need
        val sdf = SimpleDateFormat(myFormat, Locale.US)
        expDate.text = sdf.format(expcal.time)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        //liquid.name = getView()!!.liquidName.toString()
        listener = null
    }

    interface OnFragmentInteractionListener {
        fun onFragmentInteraction(uri: Uri)
    }

    companion object {
        val TAG = LiquidDetailFragment::class.java.simpleName
        @JvmStatic
        fun newInstance(param1: Liquid) =
            LiquidDetailFragment().apply {
                arguments = Bundle().apply {
                    ARG_PARAM1 = param1
                }
            }
    }
}
