package com.example.pharmandroid.Medication

import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.example.pharmandroid.R


import com.example.pharmandroid.Medication.MedicationListFragment.OnListFragmentInteractionListener
import com.example.pharmandroid.Models.Medication.Inhalant
import com.example.pharmandroid.Models.Medication.Liquid
import com.example.pharmandroid.Models.Medication.Medication
import com.example.pharmandroid.Models.Medication.Pill
import com.google.android.material.snackbar.Snackbar

import kotlinx.android.synthetic.main.med_card.view.*

class MedicationListRecyclerAdapter(
    private val mValues: List<Medication>,
    private val mListener: OnListFragmentInteractionListener?
) : RecyclerView.Adapter<MedicationListRecyclerAdapter.ViewHolder>() {

    private val mOnClickListener: View.OnClickListener
    private var listener: (() -> Unit)? = null

    init {
        mOnClickListener = View.OnClickListener { v ->
            val item = v.tag as Medication
            mListener?.onListFragmentInteraction(item)
            Log.d("clicked", item.name)
            listener?.invoke()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.med_card, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mValues[position]
        holder.Name.text = item.name
        holder.Information.text = item.Information
        holder.Total.text = item.total.toString()
        holder.Dispense.isEnabled = item.canDispense

        when (item) {
            is Pill -> {
                holder.Icon.setImageResource(R.drawable.pillmed)
                holder.Total.append(" pills left")
            }
            is Liquid -> {
                holder.Icon.setImageResource(R.drawable.liquidmed)
                holder.Total.append(" mL left")
            }
            is Inhalant -> {
                holder.Icon.setImageResource(R.drawable.inhalermed)
                holder.Total.append(" mL left")
            }
        }
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
        val Icon: ImageView = mView.imageView
        val Dispense: Button = mView.dispenseButton
    }
}
