package com.example.opscparttwopoe;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;


public class InvoiceList : AppCompatActivity() {

private lateinit var clientNameEditText: EditText
private lateinit var dateEditText: EditText
private lateinit var timeEditText: EditText
private lateinit var servicesEditText: EditText

        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_invoice_list)
        initializeViews()

        val clientName = intent.getStringExtra("EXTRA_CLIENT_NAME") ?: ""
        val date = intent.getStringExtra("EXTRA_DATE") ?: ""
        val time = intent.getStringExtra("EXTRA_TIME") ?: ""
        val services = intent.getStringExtra("EXTRA_SERVICES") ?: ""

        populateInvoiceDetails(clientName, date, time, services)
        }

        private fun initializeViews() {
        clientNameEditText = findViewById(R.id.editTextClientName)
        dateEditText = findViewById(R.id.editTextDate)
        timeEditText = findViewById(R.id.editTextTime)
        servicesEditText = findViewById(R.id.editTextServices)
        }

        private fun populateInvoiceDetails(clientName: String, date: String, time: String, services: String) {
        clientNameEditText.setText(getString(R.string.client_name_label, clientName))
        dateEditText.setText(getString(R.string.date_label, date))
        timeEditText.setText(getString(R.string.time_label, time))
        servicesEditText.setText(getString(R.string.services_label, services))
        }

}
