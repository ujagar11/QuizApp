package ud.demo.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class resultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        val name:TextView= findViewById(R.id.userName)
        name.text=intent.getStringExtra(Constants.userName)

        val score:TextView= findViewById(R.id.score)
        var cAns= intent.getStringExtra(Constants.CORRECT_ANSWERS)
        var tQues=intent.getStringExtra(Constants.TOTAL_QUESTIONS)
        val res:String=cAns+"/"+tQues
        score.text=res

        val btnFinish:Button=findViewById(R.id.btnFinish)
        btnFinish.setOnClickListener{
            val intt=Intent(this,MainActivity::class.java)
            startActivity(intt)
            finish()
        }
    }
}