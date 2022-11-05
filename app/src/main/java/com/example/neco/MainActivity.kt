package com.example.neco

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.neco.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var bindingClass : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)
        val infoMsg = R.string.infoMsg.toString()

        bindingClass.bt.setOnClickListener {
            val pass = bindingClass.edPass.text.toString()
            var tvResultText = bindingClass.tvResult.text
            bindingClass.tvResult.visibility = View.VISIBLE
            when(bindingClass.edText.text.toString().uppercase()){

                Constance.SECURITY -> {tvResultText = if(pass == Constance.SECURITY_PASSWORD)
                    Constance.SECURITY_SALARY
                    else infoMsg
                bindingClass.imPhoto.setImageResource(R.drawable.security)}

                Constance.INGENEER -> {tvResultText = if(pass == Constance.INGENEER_PASSWORD)
                    Constance.INGENEER_SALARY
                    else infoMsg
                bindingClass.imPhoto.setImageResource(R.drawable.engineer)}

                Constance.DIRECTOR -> {tvResultText = if(pass == Constance.DIRECTOR_PASSWORD)
                    Constance.DIRECTOR_SALARY
                    else infoMsg
                bindingClass.imPhoto.setImageResource(R.drawable.director)}

                else -> tvResultText = "You are not our employee"
            }
        }
    }
}