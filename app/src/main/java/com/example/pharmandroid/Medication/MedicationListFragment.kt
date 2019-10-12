package com.example.pharmandroid.Medication

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.pharmandroid.Models.Medication.Pill
import com.example.pharmandroid.R

class MedicationListFragment : Fragment() {
    val medicationList = MasterMedicationList
    private var columnCount = 1

    private var listener: OnListFragmentInteractionListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            columnCount = it.getInt(ARG_COLUMN_COUNT)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        medicationList.removePills()

        var pill = Pill()
        pill.name = "Tylenol"
        pill.total = 2
        pill.dose = 2
        pill.Information =
            "Tylenol (acetaminophen) is a pain reliever and a fever reducer. Tylenol is used to treat many conditions such as headache, muscle aches, arthritis, backache, toothaches, colds, and fevers."

        var pill2 = Pill()
        pill2.name = "Ibuprofen"
        pill2.total = 4
        pill2.dose = 3
        pill2.Information =
            "Ibuprofen is a nonsteroidal anti-inflammatory drug (NSAID). It works by reducing hormones that cause inflammation and pain in the body. Ibuprofen is used to reduce fever and treat pain or inflammation caused by many conditions such as headache, toothache, back pain, arthritis, menstrual cramps, or minor injury."

        var pill3 = Pill()
        pill3.name = "Claritin"
        pill3.total = 26
        pill3.dose = 3
        pill3.Information =
            "Claritin is an anti-histamine used to treat allergies."

        medicationList.addPill(pill)
        medicationList.addPill(pill2)
        medicationList.addPill(pill3)

        val view = inflater.inflate(R.layout.fragment_medicationlist_list, container, false)

        if (view is RecyclerView) {
            with(view) {
                layoutManager = when {
                    columnCount <= 1 -> LinearLayoutManager(context)
                    else -> GridLayoutManager(context, columnCount)
                }
                adapter = MedicationListRecyclerAdapter(medicationList.PillList, listener)
            }
        }
        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnListFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnListFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    interface OnListFragmentInteractionListener {
        fun onListFragmentInteraction(item: Pill) {}
    }

    companion object {
        // TODO: Customize parameter argument names
        const val ARG_COLUMN_COUNT = "column-count"

        // TODO: Customize parameter initialization
        @JvmStatic
        fun newInstance(columnCount: Int) =
            MedicationListFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_COLUMN_COUNT, columnCount)
                }
            }
    }
}
