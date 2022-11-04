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
            when(bindingClass.edText.text.toString()){
                "Sergey" -> bindingClass.tvResult.text = "1 000 $"
                "Andrey" -> bindingClass.tvResult.text = "5 000 $"
                "Alex" -> bindingClass.tvResult.text = "10 000 $"
                else -> bindingClass.tvResult.text = "You are not our employee"
            }
        }
    }
}