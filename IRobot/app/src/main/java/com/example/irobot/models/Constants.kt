package com.example.irobot.models

import com.example.irobot.R


object Constants {
    val USER_NAME: String = "username"
    val LAST_USER: String = "lastUser"
    val LAST_RESULT: String = "lastResult"

    fun getAllQuestion(): ArrayList<Question> {
        //Create empty Arrays
        //Create empty Arr
        var allQuestions = ArrayList<Question>()
        //TODO: 2.Create Data
        val questionOne = Question(
            1,
            "Are you a robot?",
            R.drawable.ic_baseline_help_outline_24,
            "Beep Boop",
            "No"
        )

        val questionTwo = Question(
            2,
            "What is Love?",
            R.drawable.ic_baseline_help_outline_24,
            "I dont know, get beeped pretty boy",
            "Baby don't hurt me, no more"
        )
        allQuestions.add(questionOne)
        allQuestions.add(questionTwo)
    //Return all of the data
        return allQuestions
    //This function will return all the questions.

    }
}