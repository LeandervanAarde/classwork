package com.example.irobot

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.RadioButton
import android.widget.Toast
import com.example.irobot.databinding.ActivityQuestionsBinding
import com.example.irobot.models.Constants.getAllQuestion
import com.example.irobot.models.Question

class Questions : AppCompatActivity() {

    //We need to define our binding view
    private lateinit var binding: ActivityQuestionsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuestionsBinding.inflate(layoutInflater)
        setContentView(binding.root)
            //Get the extra from the intent
        val username = intent.getStringExtra("username").toString()
        var questionNumber = intent.getIntExtra("number", 0)
        Log.i("name", username)
        //CAll for all my questions.
        val questions = getAllQuestion();
        var currentScore = intent.getIntExtra("currentScore", 0)
        val currentQuestion = questions[questionNumber]
        title = "Question " + questionNumber.toString()

        //Select current question

        Log.i("QuestionCount:","${currentQuestion.QuestionText}")
//        Log.i("QuestionCount:","${questions[1].QuestionText}")
        updateUI(currentQuestion, username)

        binding.btnNext.setOnClickListener{
            //navigate to next question
            var tempAnswer = binding.rgAnswers.checkedRadioButtonId

            if(tempAnswer == -1){
                val toast = Toast.makeText(this, "please select your answer", Toast.LENGTH_SHORT)
                toast.show()

            } else{
                var userAnswer = findViewById<RadioButton>(tempAnswer)
                Log.i("Selected" ,userAnswer.text.toString())
                // Check correct answer

                if(userAnswer.text.toString() == currentQuestion.OptionTwo){
                    currentScore += 1
                    Log.i("Correct", "Yes")

                    if(questionNumber +1 == questions.count()){
                        val thisintent = Intent(this, ResultsActivity::class.java)
                        startActivity(thisintent)
                        finish()
                    }else{
                        val intent = Intent(this, Questions::class.java)
                        //parse username and next question value
                        //' parse answers/ scores
                        intent.putExtra("username", username)
                        intent.putExtra("number", questionNumber+1)
                        intent.putExtra("currentScore", currentScore.toString())
                        startActivity(intent)
                        finish()
                    }

                    //TODO: Showcase they were wrong

                }
            }


        }

    }

    fun updateUI(currentQuestion: Question, username: String){
        if(currentQuestion.id == 1){
            binding.tvQuestion.text = "Welcome ${username}! Please tell us, ${currentQuestion.QuestionText}"
        }  else{
            binding.tvQuestion.text = "Your next question is ${currentQuestion.QuestionText}"
        }
//        binding.tvQuestion.text = "Welcome ${username}! Please tell us, ${currentQuestion.QuestionText}"
        binding.rbAnswerOne.text = currentQuestion.OptionOne
        binding.rbAnswerTwo.text = currentQuestion.OptionTwo
        binding.icon.setImageResource(currentQuestion.icon)

        //progressbar
        binding.progressBar.progress = currentQuestion.id
        binding.progressText.text = currentQuestion.id.toString() + "/3"
    }
}