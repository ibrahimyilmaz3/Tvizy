package com.application.tvizy.database

import com.application.tvizy.model.Comment
import com.application.tvizy.model.Competition
import com.application.tvizy.model.Question
import com.application.tvizy.model.Survey

object DataBase {
    var survey = ArrayList<Survey>()
    var competition = ArrayList<Competition>()
    var question = ArrayList<Question>()
    var comment = ArrayList<Comment>()
}