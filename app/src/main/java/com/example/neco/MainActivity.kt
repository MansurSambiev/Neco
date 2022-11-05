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
            bindingClass.tvResult.text = when(bindingClass.edText.text.toString()){
                "Sergey" -> "1 000 $"
                "Andrey" -> "5 000 $"
                "Alex" -> "10 000 $"
                else -> "You are not our employee"
            }
        }
    }
}