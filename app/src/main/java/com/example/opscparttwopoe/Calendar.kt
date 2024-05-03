package com.example.opscparttwopoe

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CalendarView
import android.widget.CalendarView.OnDateChangeListener
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Calendar : AppCompatActivity() {
    private var calendarView: CalendarView? = null
    private var timeInput: EditText? = null
    private var saveDateButton: Button? = null
    private var saveTimeButton: Button? = null
    private var selectedDate: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.calendar)

        // Initialize views
        calendarView = findViewById(R.id.calendarView)
        timeInput = findViewById(R.id.timeInput)
        saveDateButton = findViewById(R.id.saveDateButton)
        saveTimeButton = findViewById(R.id.saveTimeButton)

        // Set listener for date selection
        this.calendarView.setOnDateChangeListener(OnDateChangeListener { calendarView, year, month, dayOfMonth ->
            selectedDate = year.toString() + "/" + (month + 1) + "/" + dayOfMonth
        })

        // Set listener for save date button
        this.saveDateButton.setOnClickListener(View.OnClickListener {
            if (selectedDate != null) {
                Toast.makeText(
                    this@Calendar,
                    "Selected date: $selectedDate",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                Toast.makeText(this@Calendar, "Please select a date", Toast.LENGTH_SHORT)
                    .show()
            }
        })

        // Set listener for save time button
        this.saveTimeButton.setOnClickListener(View.OnClickListener {
            val selectedTime = this.timeInput.getText().toString()
            if (!selectedTime.isEmpty()) {
                Toast.makeText(
                    this@Calendar,
                    "Selected time: $selectedTime",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                Toast.makeText(this@CalendarActivity, "Please input a time", Toast.LENGTH_SHORT)
                    .show()
            }
        })
    }
}