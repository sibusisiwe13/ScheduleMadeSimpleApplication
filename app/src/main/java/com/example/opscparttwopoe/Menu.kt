package com.example.opscparttwopoe

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class Menu : AppCompatActivity() {


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.menu)

        val timesheetbtn: Button = findViewById(R.id.timesheetbtn)
        timesheetbtn.setOnClickListener {
            val intent = Intent(this,Timesheet::class.java)
            startActivity(intent)
        }
        val settingbtn: Button = findViewById(R.id.settingbtn)
        settingbtn.setOnClickListener {
            val intent = Intent(this, Settings::class.java)
            startActivity(intent)
        }
        val schedulebtn: Button = findViewById(R.id.schedulebtn)
        schedulebtn.setOnClickListener {
            val intent = Intent(this, Schedule::class.java)
            startActivity(intent)
        }
        val reportbtn: Button = findViewById(R.id.reportbtn)
        reportbtn.setOnClickListener {
            val intent = Intent(this, Report::class.java)
            startActivity(intent)
        }
        val chatsbtn: Button = findViewById(R.id.chatsbtn)
        chatsbtn.setOnClickListener {
            val intent = Intent(this, Chats::class.java)
            startActivity(intent)
        }
        val calendarbtn: Button = findViewById(R.id.calendarbtn)
        calendarbtn.setOnClickListener {
            val intent = Intent(this, Calendar::class.java)
            startActivity(intent)
        }
        val invoicebtn: Button = findViewById(R.id.invoicebtn)
        invoicebtn.setOnClickListener {
            val intent = Intent(this, Invoice::class.java)
            startActivity(intent)
        }

    }

}