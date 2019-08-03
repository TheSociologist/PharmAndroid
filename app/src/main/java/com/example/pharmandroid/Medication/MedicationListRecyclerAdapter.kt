package com.example.pharmandroid.Medication

import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.pharmandroid.R


import com.example.pharmandroid.Medication.MedicationListFragment.OnListFragmentInteractionListener
import com.google.android.material.snackbar.Snackbar

import kotlinx.android.synthetic.main.pill_card.view.*

class MedicationListRecyclerAdapter(
    private val mValues: List<Pill>,
    private val mListener: OnListFragmentInteractionListener?
) : RecyclerView.Adapter<MedicationListRecyclerAdapter.ViewHolder>() {

    private val mOnClickListener: View.OnClickListener
    private var listener: (() -> Unit)? = null

    fun setListener(listener: (() -> Unit)?) {
        this.listener = listener
    }

    init {
        mOnClickListener = View.OnClickListener { v ->
            val item = v.tag as Pill
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
            .inflate(R.layout.pill_card, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mValues[position]
        holder.Name.text = item.name
        holder.Information.text = item.Information
        holder.Total.text = item.total.toString() + " Pills Left"

        with(holder.mView) {
            tag = item
            setOnClickListener(mOnClickListener)
        }
    }

    override fun getItemCount(): Int = mValues.size

    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        val Name: TextView = mView.pillName
        val Information: TextView = mView.pillInfo
        val Total: TextView = mView.pillTotal
    }
}
