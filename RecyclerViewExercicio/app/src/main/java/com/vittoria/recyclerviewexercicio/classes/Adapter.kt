package com.vittoria.recyclerviewexercicio.classes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.vittoria.recyclerviewexercicio.R
import kotlinx.android.synthetic.main.item_list.view.*

class Adapter(private val dataSet: List<Chat>) : RecyclerView.Adapter<Adapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        private val name : TextView = view.findViewById(R.id.txtName)
        private val message : TextView = view.findViewById(R.id.txtMessage)
        private val time : TextView = view.findViewById(R.id.txtTime)

        fun bind(nameValue: String, messageValue: String, timeValue: String){
            name.text = nameValue;
            message.text = messageValue;
            time.text = timeValue;

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount() = dataSet.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(dataSet[position].name, dataSet[position].message, dataSet[position].time)
    }
}