package com.example.pharmandroid.Dashboard

import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.pharmandroid.R


import com.example.pharmandroid.Dashboard.DashboardFragment.OnListFragmentInteractionListener
import com.google.android.material.snackbar.Snackbar
import com.example.pharmandroid.Models.Notifications.LowPillCount

import kotlinx.android.synthetic.main.notification_card.view.*

class NotificationListRecyclerAdapter(
    private val mValues: List<LowPillCount>,
    private val mListener: OnListFragmentInteractionListener?
) : RecyclerView.Adapter<NotificationListRecyclerAdapter.ViewHolder>() {

    private val mOnClickListener: View.OnClickListener
    private var listener: (() -> Unit)? = null

    fun setListener(listener: (() -> Unit)?) {
        this.listener = listener
    }

    init {
        mOnClickListener = View.OnClickListener { v ->
            val item = v.tag as LowPillCount
            mListener?.onListFragmentInteraction(item)
            Log.d("clicked", item.name)
            Snackbar.make(
                v, "Click detected on item $item.name",
                Snackbar.LENGTH_LONG
            ).setAction("Action", null).show()
            listener?.invoke()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.notification_card, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mValues[position]
        holder.Type.text = "Only " + item.num.toString() + " " + item.name + " left"

        with(holder.mView) {
            tag = item
            setOnClickListener(mOnClickListener)
        }
    }

    override fun getItemCount(): Int = mValues.size

    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        val Type: TextView = mView.noteType
    }
}
