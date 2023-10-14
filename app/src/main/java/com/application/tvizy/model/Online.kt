package com.application.tvizy.model

import android.text.SpannableString

data class Online(
    var survey: Survey?,
    var competition: Competition?,
    var question: Question?,
    var comment: Comment?,
    var video: Video?,
    val viewType: String
)

data class Survey(
    var series: Int,
    var name: String,
    var background: Int,
    var banner: Int,
    var question: String,
    var option1: SpannableString,
    var option2: SpannableString
)

data class Competition(
    var series: Int,
    var name: String,
    var background: Int,
    var banner: Int,
    var question1: String,
    var option1a: SpannableString,
    var option1b: SpannableString,
    var question2: String,
    var option2a: SpannableString,
    var option2b: SpannableString,
    var question3: String,
    var option3a: SpannableString,
    var option3b: SpannableString
)

data class Question(
    var series: Int,
    var name: String,
    var background: Int,
    var banner: Int,
    var question: String
)

data class Comment(
    var series: Int,
    var name: String,
    var background: Int,
    var banner: Int,
    var comment: String
)

data class Video(var url: String, var banner: Int)