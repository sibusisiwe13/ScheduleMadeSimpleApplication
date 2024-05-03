package com.example.opscparttwopoe

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Message
import android.widget.Button
import android.widget.EditText
import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler

import com.google.firebase.auth.FirebaseAuth

class Chats : AppCompatActivity() {
    private lateinit var recycler: Recycler
    private lateinit var messages: RelativeLayout
    private lateinit var chatstxt: EditText
    private lateinit var sendbtn: Button
    private lateinit var auth: FirebaseAuth


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.chats)
        auth = FirebaseAuth.getInstance()
        val recycler: RecyclerView = findViewById(R.id.recycler)
        recycler.layoutManager = LinearLayoutManager(this)


    }




}