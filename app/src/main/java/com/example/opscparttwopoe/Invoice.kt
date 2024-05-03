package com.example.opscparttwopoe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class Invoice : AppCompatActivity() {

    private val invoicesList = mutableListOf<InvoiceItem>()

    private lateinit var clientNameEditText: EditText
    private lateinit var dateEditText: EditText
    private lateinit var timeEditText: EditText
    private lateinit var servicesEditText: EditText
    private lateinit var generateInvoiceButton: Button
    private lateinit var viewAllInvoicesButton: Button
    private lateinit var clearFieldsButton: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_invoice)

        clientNameEditText = findViewById(R.id.editTextClientName)
        dateEditText = findViewById(R.id.editTextDate)
        timeEditText = findViewById(R.id.editTextTime)
        servicesEditText = findViewById(R.id.editTextServices)
        generateInvoiceButton = findViewById(R.id.buttonGenerateInvoice)
        viewAllInvoicesButton = findViewById(R.id.buttonViewAllInvoices)
        clearFieldsButton = findViewById(R.id.buttonClearFields)

        generateInvoiceButton.setOnClickListener {
            generateInvoice()

        }

        viewAllInvoicesButton.setOnClickListener {

            viewAllInvoices()

        }

        clearFieldsButton.setOnClickListener {
            clearFields()
        }
    }

    private fun clearFields() {
        clientNameEditText.text.clear()
        dateEditText.text.clear()
        timeEditText.text.clear()
        servicesEditText.text.clear()
    }

    private fun generateInvoice() {
        val clientName = clientNameEditText.text.toString()
        val date = dateEditText.text.toString()
        val time = timeEditText.text.toString()
        val services = servicesEditText.text.toString()

        if (clientName.isEmpty() || date.isEmpty() || time.isEmpty() || services.isEmpty()) {
            runOnUiThread {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            }
            return
        }

        val invoice = InvoiceItem(clientName, date, time, services)
        invoicesList.add(invoice)

        runOnUiThread {

            Toast.makeText(this, "Invoice Generated", Toast.LENGTH_SHORT).show()

        }
    }

    private fun viewAllInvoices() {
        val clientName = clientNameEditText.text.toString()
        val date = dateEditText.text.toString()
        val time = timeEditText.text.toString()
        val services = servicesEditText.text.toString()

        startActivity(Intent(this, InvoiceList::class.java).
        putExtra("EXTRA_CLIENT_NAME", clientName)
            .putExtra("EXTRA_DATE", date)
            .putExtra("EXTRA_TIME", time)
            .putExtra("EXTRA_SERVICES", services))
    }


    private fun callActivity(){

        val clientName = clientNameEditText.text.toString()
        val date = dateEditText.text.toString()
        val time = timeEditText.text.toString()
        val services = servicesEditText.text.toString()


    }
}