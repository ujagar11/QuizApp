package ud.demo.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat

class QuizQuestionsActivity : AppCompatActivity(),OnClickListener {
    private var progressBar: ProgressBar?=null
    private var numberQues: TextView?=null
    private var btnSubmit: Button?=null
    private var option1: TextView?=null
    private var option2: TextView?=null
    private var option3: TextView?=null
    private var option4: TextView?=null
    private var img: ImageView?=null

    private var correctAns:Int=0

    private  var QuestionList:ArrayList<Question>?=null
    private var currentLocation:Int=1
    private var selectedPosition:Int=0
    private var userName:String?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        userName=intent.getStringExtra(Constants.userName)

        progressBar=findViewById(R.id.progressBar)
        numberQues=findViewById(R.id.numberQues)
        btnSubmit=findViewById(R.id.btnSubmit)
        option1=findViewById(R.id.option1)
        option2=findViewById(R.id.option2)
        option3=findViewById(R.id.option3)
        option4=findViewById(R.id.option4)
        img=findViewById(R.id.img)

        option1?.setOnClickListener(this)
        option2?.setOnClickListener(this)
        option3?.setOnClickListener(this)
        option4?.setOnClickListener(this)

        btnSubmit?.setOnClickListener(this)
        QuestionList=Constants.getQuestions()

        setQuestion()


    }

    private fun  setQuestion() {
        var question: Question = QuestionList!![currentLocation - 1]
        progressBar?.progress = currentLocation
        numberQues?.text = "${currentLocation}/${progressBar?.max}"
        option1?.text = question.option1
        option2?.text = question.option2
        option3?.text = question.option3
        option4?.text = question.option4
        img?.setImageResource(question.image)

        if(currentLocation==QuestionList!!.size){
            btnSubmit?.text="FINISH"
        }
        else{
            btnSubmit?.text="SUBMIT"
        }
    }
    private fun defaultOptionView(){

        val options = ArrayList<TextView>()
        option1?.let {
            options.add(0,it)
        }
        option2?.let {
            options.add(1,it)
        }
        option3?.let {
            options.add(2,it)
        }
        option4?.let {
            options.add(3,it)
        }
        for(option in options){

            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface= Typeface.DEFAULT
            option.background=ContextCompat.getDrawable(
              this,
                R.drawable.default_option_border_bg
            )
        }

    }

    private fun selectedOptionView(tv:TextView,selectedOptionNum:Int){
        defaultOptionView()

        selectedPosition=selectedOptionNum
        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface,Typeface.BOLD)
        tv.background=ContextCompat.getDrawable(
            this,
            R.drawable.selected_option_border_bg
        )
    }

    override fun onClick(view: View?) {
       when(view?.id){
           R.id.option1->{
               option1?.let {
                   selectedOptionView(it,1)
               }
           }
           R.id.option2->{
               option2?.let {
                   selectedOptionView(it,2)
               }
           }
           R.id.option3->{
               option3?.let {
                   selectedOptionView(it,3)
               }
           }
           R.id.option4->{
               option4?.let {
                   selectedOptionView(it,4)
               }
           }
           R.id.btnSubmit->{

                 if(selectedPosition==0){
                     defaultOptionView()
                     currentLocation++
                     when{
                         currentLocation<=QuestionList!!.size->{
                             setQuestion()
                         }
                         else-> {
                             val intent=Intent(this,resultActivity::class.java)
                             intent.putExtra(Constants.userName,userName)
                             intent.putExtra(Constants.CORRECT_ANSWERS,correctAns.toString())
                             intent.putExtra(Constants.TOTAL_QUESTIONS,QuestionList!!.size.toString())
                             startActivity(intent)
                             finish()
                         }
                     }
                 }else {
                     val question = QuestionList?.get(currentLocation - 1)
                     if (question!!.correctOption != selectedPosition) {
                         answerView(selectedPosition, R.drawable.wrong_option_border_bg)
                     }
                     else{
                         correctAns++
                     }
                         answerView(question.correctOption, R.drawable.correct_option_border_bg)
                     if(currentLocation==QuestionList!!.size){
                         btnSubmit?.text="FINISH"
                     }else{
                         btnSubmit?.text="GO TO NEXT QUESTION"
                     }
                     selectedPosition=0
                 }
           }
       }
    }

    private fun answerView(answer:Int,drawbleView:Int){
        when(answer){
            1->{
                option1?.setTextColor(Color.parseColor("#ffffff"))
                option1?.background=ContextCompat.getDrawable(
                    this,
                    drawbleView
                )
            }
            2->{
                option2?.setTextColor(Color.parseColor("#ffffff"))
                option2?.background=ContextCompat.getDrawable(
                    this,
                    drawbleView
                )
            }
            3->{
                option3?.setTextColor(Color.parseColor("#ffffff"))
                option3?.background=ContextCompat.getDrawable(
                    this,
                    drawbleView
                )
            }
            4->{
                option4?.setTextColor(Color.parseColor("#ffffff"))
                option4?.background=ContextCompat.getDrawable(
                    this,
                    drawbleView
                )
            }

        }
    }
}