package com.example.pharmandroid.Manage

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.pharmandroid.R
import kotlinx.android.synthetic.main.fragment_user_detail.view.*

import android.icu.util.Calendar
import android.widget.Button
import com.example.pharmandroid.Models.User.User


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private var ARG_PARAM1: User =
    User()

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [PillDetailFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [PillDetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class UserDetailFragment : Fragment() {
    private var user: User =
        User()
    private var listener: OnFragmentInteractionListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            user = ARG_PARAM1
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_user_detail, container, false)
        view.userName.setText(user.firstName + " " + user.lastName)

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
        //pill.name = getView()!!.pillName.toString()
        listener = null
    }

    interface OnFragmentInteractionListener {
        fun onFragmentInteraction(uri: Uri)
    }

    companion object {
        val TAG = UserDetailFragment::class.java.simpleName
        @JvmStatic
        fun newInstance(param1: User) =
            UserDetailFragment().apply {
                arguments = Bundle().apply {
                    ARG_PARAM1 = param1
                }
            }
    }
}
