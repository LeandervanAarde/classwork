package com.example.irobot

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.irobot.databinding.ActivityMainBinding
import com.example.irobot.databinding.ActivityQuestionsBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnStart.setOnClickListener{
            Log.i("Clicked", "YES!")
            val userName = binding.etUsername.text
                //TODO: add toast or some sort of validation (warning)

            if(userName.toString() ==  ""){
                Toast.makeText(this, "Please enter your name", Toast.LENGTH_LONG).show()
                binding.etUsername.error = "Please add UserName"
//                Snackbar.make(it, "Please enter your name", Snackbar.LENGTH_LONG).setAction("ok",{Log.i("Hello", "yessir")}).show()
            } else{
                //TODO: Navigate to next activity
                val intent = Intent(this,Questions::class.java)
                intent.putExtra("username", userName.toString())
                startActivity(intent)
                //We are parsing data
//                finish()
            }
            Log.i("username", "$userName")
        }
    }

    //add event listener to button

}