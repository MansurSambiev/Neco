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

        bindingClass.bt.setOnClickListener {
            bindingClass.tvResult.visibility = View.VISIBLE
            bindingClass.tvResult.text = when(bindingClass.edText.text.toString().uppercase()){
                Constance.SECURITY -> if(bindingClass.edPass.text.toString() == Constance.SECURITY_PASSWORD)
                    Constance.SECURITY_SALARY
                    else "Invalid password"

                Constance.INGENEER -> if(bindingClass.edPass.text.toString() == Constance.INGENEER_PASSWORD)
                    Constance.INGENEER_SALARY
                else "Invalid password"
                Constance.DIRECTOR -> if(bindingClass.edPass.text.toString() == Constance.DIRECTOR_PASSWORD)
                    Constance.DIRECTOR_SALARY
                else "Invalid password"
                else -> "You are not our employee"
            }
        }
    }
}