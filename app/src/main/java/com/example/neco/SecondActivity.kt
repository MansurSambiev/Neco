package com.example.neco

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.neco.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var bindingClass : ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)

        val message = intent.getStringExtra("question")
        bindingClass.tvMessage.text = message

        bindingClass.btGoToMain.setOnClickListener(){
            intent.putExtra("answer", bindingClass.edAnswer.text.toString())
            setResult(RESULT_OK, intent)
            finish()
        }
    }
}