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
import kotlinx.android.synthetic.main.fragment_pill_detail.view.*
import android.widget.DatePicker

import android.icu.text.SimpleDateFormat
import android.icu.util.Calendar
import android.widget.Button
import com.example.pharmandroid.Models.Medication.Pill
import java.util.*





// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private var ARG_PARAM1: Pill =
    Pill()
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [PillDetailFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [PillDetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class PillDetailFragment : Fragment() {
    lateinit var preDate: Button
    lateinit var expDate: Button

    private var pill: Pill =
        Pill()
    private var listener: OnFragmentInteractionListener? = null

    var precal = Calendar.getInstance()
    var expcal = Calendar.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            pill = ARG_PARAM1
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_pill_detail, container, false)
        view.pillName.setText(pill.name)
        view.pillTotal.setText(pill.total.toString())
        view.pillDose.setText(pill.dose.toString())
        view.pillInfo.setText(pill.Information)
        view.pillExpired.text = "${pill.ExpiryDate.dayOfMonth}/${pill.ExpiryDate.month}/${pill.ExpiryDate.year}"
        view.pillPrescribed.text =
            "${pill.PrescribedDate.dayOfMonth}/${pill.PrescribedDate.month}/${pill.PrescribedDate.year}"

        expDate = view.pillExpired
        preDate = view.pillPrescribed

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
        //pill.name = getView()!!.pillName.toString()
        listener = null
    }

    interface OnFragmentInteractionListener {
        fun onFragmentInteraction(uri: Uri)
    }

    companion object {
        val TAG = PillDetailFragment::class.java.simpleName
        @JvmStatic
        fun newInstance(param1: Pill) =
            PillDetailFragment().apply {
                arguments = Bundle().apply {
                    ARG_PARAM1 = param1
                }
            }
    }
}
