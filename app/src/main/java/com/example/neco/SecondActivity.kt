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

        bindingClass.btGoToMain.setOnClickListener(){
            if(bindingClass.edLogin.text.toString() == userLogin)
                bindingClass.tvMessage.text = "Этот логин занят"
            else{
                var newLogin = bindingClass.edLogin.text.toString()
                var newPass = bindingClass.edPass.text.toString()
                intent.putExtra("answer", "Добро пожаловать, ${bindingClass.edName.text.toString()} ${bindingClass.edSurname.text.toString()}")
//                При передаче переменной не выдает текст
                setResult(RESULT_OK, intent)
                finish()}
        }
    }
}