package com.application.tvizy.model

import android.text.SpannableString

data class Story(
    var survey: Survey2?,
    var competition: Competition2?,
    var question: Question2?,
    var comment: Comment2?,
    var ads: Ads?,
    val viewType: String
)

data class Ads(val icon: Int, val text: String, val image: Int )

data class Survey2(
    var channelIcon:Int,
    var channelName: String,

    var series: Int,
    var name: String,
    var background: Int,
    var banner: Int,
    var question: String,
    var option1: SpannableString,
    var option2: SpannableString
)

data class Competition2(
    var channelIcon:Int,
    var channelName: String,

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

data class Question2(
    var channelIcon:Int,
    var channelName: String,

    var series: Int,
    var name: String,
    var background: Int,
    var banner: Int,
    var question: String
)

data class Comment2(
    var channelIcon:Int,
    var channelName: String,

    var series: Int,
    var name: String,
    var background: Int,
    var banner: Int,
    var comment: String
)
