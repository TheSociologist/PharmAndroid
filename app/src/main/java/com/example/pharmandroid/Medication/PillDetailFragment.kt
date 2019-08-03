package com.example.pharmandroid.Medication

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import com.example.pharmandroid.R
import kotlinx.android.synthetic.main.fragment_pill_detail.*
import kotlinx.android.synthetic.main.fragment_pill_detail.view.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private var ARG_PARAM1: Pill = Pill()
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
    // TODO: Rename and change types of parameters
    private var pill: Pill = Pill()
    private var listener: OnFragmentInteractionListener? = null

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
        view.pillInfo.setText(pill.Information.toString())
        return view
    }

    // TODO: Rename method, update argument and hook method into UI event
    fun onButtonPressed(uri: Uri) {
        listener?.onFragmentInteraction(uri)
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
