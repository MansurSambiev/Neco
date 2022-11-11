package com.example.neco

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.neco.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var bindingClass : ActivitySecondBinding

    private val userLogin = "Alex"
    private val userPass = "2312"
    private var newLogin = "null"
    private var newPass = "null"
    private var name = "Alex"
    private var newName = ""
    private var surName = "Maxim"
    private var newSurName = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)


        val signState = intent.getStringExtra(Constance.SiGN_STATE)

        if (signState == Constance.SiGN_IN_STATE){
            bindingClass.edName.visibility = View.GONE
            bindingClass.edSurname.visibility = View.GONE
            bindingClass.tvMessage.text = getString(R.string.signInInfo)
        }
        else bindingClass.tvMessage.text = getString(R.string.signUpInfo)

        bindingClass.btGoToMain.setOnClickListener{
            if(signState == Constance.SiGN_UP_STATE) {
                if (bindingClass.edLogin.text.toString() == userLogin || bindingClass.edLogin.text.toString() == newLogin)
                    bindingClass.tvMessage.text = "Этот логин занят"
                else {
                    newLogin = bindingClass.edLogin.text.toString()
                    newPass = bindingClass.edPass.text.toString()
                    newName = bindingClass.edName.text.toString()
                    newSurName = bindingClass.edSurname.text.toString()

                    intent.putExtra(
                        "answer",
                        "Добро пожаловать, $newName $newSurName"
                    )
                    setResult(RESULT_OK, intent)
                    finish()
                }
            }
            if(bindingClass.edLogin.text.toString() == userLogin && bindingClass.edPass.text.toString() == userPass){
                intent.putExtra(
                    "answer",
                    "Добро пожаловать, $name $surName"
                )
                setResult(RESULT_OK, intent)
                finish()
            }
            else if((bindingClass.edLogin.text.toString() == newLogin && bindingClass.edPass.text.toString() == newPass)){
                intent.putExtra(
                    "answer",
                    "Добро пожаловать, $newName $newSurName"
                )
                setResult(RESULT_OK, intent)
                finish()
            }

        }
    }
}