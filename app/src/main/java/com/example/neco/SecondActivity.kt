package com.example.neco

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.neco.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var bindingClass : ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)

        val message = intent.getStringExtra("question")
        bindingClass.tvMessage.text = message

        val userLogin = "Alex"
        val userPass = "2312"
        var newLogin = ""
        var newPass = ""

        val person = "Добро пожаловать, ${bindingClass.edName.text} $${bindingClass.edSurname.text}"



        bindingClass.btGoToMain.setOnClickListener(){
            if(bindingClass.edLogin.text.toString() == userLogin)
                bindingClass.tvMessage.text = "Этот логин занят"
            else
                newLogin = bindingClass.edLogin.text.toString()
                newPass = bindingClass.edPass.text.toString()
                intent.putExtra("answer", person)
                setResult(RESULT_OK, intent)
                finish()
        }
    }
}