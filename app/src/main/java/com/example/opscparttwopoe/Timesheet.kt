package com.example.opscparttwopoe

import android.annotation.SuppressLint
import android.app.Activity
import android.app.AlertDialog
import android.content.ClipData.Item
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Spinner
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.google.firebase.auth.FirebaseAuth





class Timesheet : AppCompatActivity() {
 private lateinit var date : EditText
 private lateinit var endTime: EditText
 private lateinit var startTime : EditText
 private lateinit var description : EditText
 private lateinit var dropdown : Spinner
 private lateinit var create :Button
 private lateinit var edit : Button
 private lateinit var delete :Button
 private lateinit var photo : ImageView
 private lateinit var addimage : Button
 private lateinit var sms : Button
 private lateinit var SelectedCategory:EditText
 private lateinit var auth:FirebaseAuth

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        val REQUEST_IMAGE_PICK = 200
        if(resultCode == REQUEST_IMAGE_PICK && resultCode == Activity.RESULT_OK && data != null){
            val imageUri: Uri? = data.data
        }
    }

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.timesheet)
        auth = FirebaseAuth.getInstance()
        date = findViewById(R.id.date)
        endTime = findViewById(R.id.endTime)
        startTime = findViewById(R.id.startTime)
        description = findViewById(R.id.description)
        photo = findViewById(R.id.photo)
        addimage = findViewById(R.id.addimage)
        sms = findViewById(R.id.sms)
        SelectedCategory = findViewById(R.id.SelectedCategory)
        create = findViewById(R.id.create)
        edit = findViewById(R.id.edit)
        delete = findViewById(R.id.delete)
        dropdown = findViewById(R.id.dropdown)
        fetchCategories()

        val adapter = ArrayAdapter.createFromResource(
            this, R.array.dropdown_options,
            android.R.layout.simple_spinner_dropdown_item

        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        dropdown.adapter = adapter
        dropdown.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val selectedCategory = parent?.getItemAtPosition(position).toString()
               SelectedCategory.setText(selectedCategory)

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        val create: Button = findViewById(R.id.create)
        create.setOnClickListener {
        startActivity(Intent(this, Task::class.java))
        finish()
            saveTask()
        }
        val delete: Button = findViewById(R.id.delete)
        delete.setOnClickListener {
            val date = date
            val endTime = endTime
            val startTime = startTime
            val description = description
            val alertDialog = AlertDialog.Builder(this)
            alertDialog.setMessage("Do you want to delete your Task?")
            alertDialog.setPositiveButton("YES") { _, _ ->

            }
            deleteTask()
        }
        val edit: Button = findViewById(R.id.edit)
        edit.setOnClickListener {
            editTask()
        }
        val addimage: Button = findViewById(R.id.addimage)
        addimage.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            val REQUEST_IMAGE_PICK = 200
            startActivityForResult(intent, REQUEST_IMAGE_PICK)


        }



        
        }

    private fun editTask() {
        val date = intent.getStringExtra("date")
        val endTime = intent.getStringExtra("endTime")
        val startTime = intent.getStringExtra("startTime")
        val description = intent.getStringExtra("description")
        val categories =intent.getStringExtra("categories")

    }

    private fun deleteTask() {



    }



    private fun saveTask() {
        val date = date.text.toString()
        val endTime = endTime.text.toString()
        val startTime = startTime.text.toString()
        val description = description.text.toString()
        val categories = dropdown.selectedItem.toString()


        TODO("Not yet implemented")
    }

    private fun fetchCategories() {
        val categories = listOf(
            "TASK 1: StartTime-08:00am,EndTime-16:00pm",
            "TASK 2: StartTime-10:00am, EndTime-14:00pm",
            "TASK 3: StartTime-10:30am, EndTime-14:30pm",
            "TASK 4: StartTime-11:00am, EndTime-14:00pm",
            "TASK 5: StartTime-12:00am, EndTime-15:00pm",
            "TASK 6: StartTime-13:00am, EndTime-18:00pm"
        )
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, categories)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        dropdown.adapter = adapter

    }

}


