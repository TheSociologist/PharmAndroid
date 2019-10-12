package com.example.pharmandroid.Manage

import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.pharmandroid.R


import com.example.pharmandroid.Manage.ManageFragment.OnListFragmentInteractionListener
import com.google.android.material.snackbar.Snackbar
import com.example.pharmandroid.Models.User.User

import kotlinx.android.synthetic.main.user_card.view.*

class UserListRecyclerAdapter(
    private val mValues: List<User>,
    private val mListener: OnListFragmentInteractionListener?
) : RecyclerView.Adapter<UserListRecyclerAdapter.ViewHolder>() {

    private val mOnClickListener: View.OnClickListener
    private var listener: (() -> Unit)? = null

    fun setListener(listener: (() -> Unit)?) {
        this.listener = listener
    }

    init {
        mOnClickListener = View.OnClickListener { v ->
            val item = v.tag as User
            mListener?.onListFragmentInteraction(item)
            Log.d("clicked", item.firstName)
            Snackbar.make(
                v, "Click detected on item $item.name",
                Snackbar.LENGTH_LONG
            ).setAction("Action", null).show()
            listener?.invoke()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.user_card, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mValues[position]
        holder.Name.text = item.firstName + " " + item.lastName

        with(holder.mView) {
            tag = item
            setOnClickListener(mOnClickListener)
        }
    }

    override fun getItemCount(): Int = mValues.size

    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        val Name: TextView = mView.userName
        val Pic: ImageView = mView.userPic

    }
}
