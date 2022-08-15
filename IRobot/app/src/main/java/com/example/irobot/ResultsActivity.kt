package com.example.irobot

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.irobot.databinding.ActivityQuestionsBinding
import com.example.irobot.databinding.ActivityResultsBinding
import com.example.irobot.models.Constants

class ResultsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultsBinding.inflate(layoutInflater)

        setContentView(binding.root)

        //TODO: update scores
        val finalScore = intent.getIntExtra("currentScore", 0)

        Log.i("finalScore", finalScore.toString())
        binding.tvResults.text = "$finalScore/2"
        if( finalScore >= 2){
            binding.message.text = "You are a robot!"

        } else{
            binding.message.text = "You are a Human!"
        }

        binding.home.setOnClickListener{
//            lastResults(username.toStrign())
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }


    fun lastResults(username: String, Score:Int){
        val sharedPref = getSharedPreferences("MyPref", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.apply{
            putString(Constants.LAST_USER, username)
//            putString(Constants.LAST_RESULT, finalScore)
            apply()
        }
    }
}