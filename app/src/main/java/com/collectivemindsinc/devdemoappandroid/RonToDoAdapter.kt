package com.collectivemindsinc.devdemoappandroid

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date

class RonToDoAdapter(private val itemsList: List<ToDoItem>, context: Context): RecyclerView.Adapter<RonToDoAdapter.ViewHolder>() {
    val cont = context

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        var txt: TextView = view.findViewById(R.id.txtView)
        var txtDate: TextView = view.findViewById(R.id.txtDateView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.to_do, parent, false))
    }

    override fun getItemCount(): Int {
        return itemsList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val toDoViewModel = itemsList[position]

        val pattern = "MM/dd/yyyy HH:mm:ss"


// Create an instance of SimpleDateFormat used for formatting
// the string representation of date according to the chosen pattern
        val df: DateFormat = SimpleDateFormat(pattern)


// Get the today date using Calendar object.
        val today: Date? = Calendar.getInstance().getTime()


// Using DateFormat format method we can create a string
// representation of a date with the defined format.
        val todayAsString: String? = df.format(toDoViewModel.date)

        holder.txt.text = toDoViewModel.text
        holder.txtDate.text = todayAsString
    }
}