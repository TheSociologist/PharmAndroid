@file:Suppress("NAME_SHADOWING")
package com.example.pharmandroid.Medication

import android.app.DatePickerDialog
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.pharmandroid.R
import kotlinx.android.synthetic.main.fragment_inhalant_detail.view.*
import android.icu.util.Calendar
import android.util.Log
import android.widget.Button
import com.example.pharmandroid.Models.Medication.Inhalant
import com.google.android.material.snackbar.Snackbar


class InhalantDetailFragment : Fragment() {
    lateinit var preDate: Button
    lateinit var expDate: Button

    private var inhalant: Inhalant =
        Inhalant()
    private var listener: OnFragmentInteractionListener? = null

    var precal = Calendar.getInstance()
    var expcal = Calendar.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_inhalant_detail, container, false)
        view.inhalantName.setText(inhalant.name)
        view.inhalantTotal.setText(inhalant.total.toString())
        view.inhalantDose.setText(inhalant.dose.toString())
        view.inhalantInfo.setText(inhalant.Information)
        view.inhalantExpired.text = "${inhalant.ExpiryDate.dayOfMonth}/${inhalant.ExpiryDate.month}/${inhalant.ExpiryDate.year}"
        view.inhalantPrescribed.text =
            "${inhalant.PrescribedDate.dayOfMonth}/${inhalant.PrescribedDate.month}/${inhalant.PrescribedDate.year}"
        view.saveButton.setOnClickListener {
            save(view)
        }
        view.backButton.setOnClickListener {
            Log.d("Working", "Working")
            requireActivity().run {
                startActivity(Intent(this, MedicationActivity::class.java))
                finish() // If activity no more needed in back stack
            }
        }
        expDate = view.inhalantExpired
        preDate = view.inhalantPrescribed
        expDate.text = "Expired " + sdf.format(expcal.time)
        if (expcal.time.before(precal.time)) {
            expDate.text = "Expired " + sdf.format(expcal.time)
        } else {
            expDate.text = "Expires " + sdf.format(expcal.time)
        }

        expDate.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View) {
                DatePickerDialog(
                    context!!,
                    DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                        expcal.set(Calendar.YEAR, year)
                        expcal.set(Calendar.MONTH, monthOfYear)
                        expcal.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                        if (expcal.time.before(precal.time)) {
                            expDate.text = "Expired " + sdf.format(expcal.time)
                        } else {
                            expDate.text = "Expires " + sdf.format(expcal.time)
                        }
                    },
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
                    DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                        precal.set(Calendar.YEAR, year)
                        precal.set(Calendar.MONTH, monthOfYear)
                        precal.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                        preDate.text = "Prescribed " + sdf.format(precal.time)
                    },
                    precal.get(Calendar.YEAR),
                    precal.get(Calendar.MONTH),
                    precal.get(Calendar.DAY_OF_MONTH)
                ).show()
            }
        })
        return view
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
        listener = null
    }

    private fun save(view: View) {
        Snackbar.make(
            view, "Saved " + inhalant.name,
            Snackbar.LENGTH_LONG
        ).setAction("Action", null).show()
    }

    interface OnFragmentInteractionListener {
        fun onFragmentInteraction(uri: Uri)
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: Inhalant) =
            InhalantDetailFragment().apply {
                arguments = Bundle().apply {
                    inhalant = param1
                }
            }
    }
}
