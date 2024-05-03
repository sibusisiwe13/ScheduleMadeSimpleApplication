package com.example.opscparttwopoe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    private lateinit var imageView2 : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageView2 = findViewById(R.id.imageView2)
        startActivity(Intent(this, Register::class.java))

        val newInvoice = findViewById<Button>(R.id.btnStart)
        newInvoice.setOnClickListener {
            val Intent = Intent(this, Invoice::class.java)
            startActivity(Intent)
        }
    }
}