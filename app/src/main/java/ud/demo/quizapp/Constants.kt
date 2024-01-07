package ud.demo.quizapp

object Constants {
    const val userName:String="user_name"
    const val TOTAL_QUESTIONS:String="total_question"
    const val CORRECT_ANSWERS:String="correct_answers"
    fun getQuestions():ArrayList<Question>{
        val questionList=ArrayList<Question>()
        val que1=Question(
            1,"what country this flag belongs",
            R.drawable.argentina,
            "argentina",
            "india",
            "brasil",
            "portugal",
            1
        )
        questionList.add(que1)
        val que2=Question(
            2,"what country this flag belongs",
            R.drawable.belgium,
            "norway",
            "mexico",
            "argentina",
            "belgium",
            4
        )
        questionList.add(que2)
        val que3=Question(
            3,"what country this flag belongs",
            R.drawable.brasil,
            "sweden",
            "india",
            "brasil",
            "none of them",
            3
        )
        questionList.add(que3)
        val que4=Question(
            4,"what country this flag belongs",
            R.drawable.france,
            "italy",
            "united states",
            "france",
            "portugal",
            3
        )
        questionList.add(que4)
        val que5=Question(
            5,"what country this flag belongs",
            R.drawable.germany,
            "france",
            "germany",
            "luxemburg",
            "brasil",
            2
        )
        questionList.add(que5)
        val que6=Question(
            6,"what country this flag belongs",
            R.drawable.south_korea,
            "south_korea",
            "india",
            "brasil",
            "portugal",
            1
        )
        questionList.add(que6)
        val que7=Question(
            7,"what country this flag belongs",
            R.drawable.united_kingdom,
            "argentina",
            "united kingdom",
            "thailand",
            "russia",
            2
        )
        questionList.add(que7)
        val que8=Question(
            8,"what country this flag belongs",
            R.drawable.united_states,
            "ubezkistan",
            "pakistan",
            "brasil",
            "none of them",
            4
        )
        questionList.add(que8)
        return questionList
    }
}