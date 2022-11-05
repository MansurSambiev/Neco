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
        val infoMsg = getString(R.string.infoMsg)

        bindingClass.bt.setOnClickListener {
            val pass = bindingClass.edPass.text.toString()
            bindingClass.tvResult.visibility = View.VISIBLE
            when(bindingClass.edText.text.toString().uppercase()){

                Constance.SECURITY -> {if(pass == Constance.SECURITY_PASSWORD){
                    bindingClass.tvResult.text = Constance.SECURITY_SALARY
                    bindingClass.imPhoto.setImageResource(R.drawable.security)
                }
                    else {bindingClass.tvResult.text = infoMsg
                    bindingClass.imPhoto.setImageResource(R.drawable.stop)}
                }

                Constance.INGENEER -> {if(pass == Constance.INGENEER_PASSWORD){
                    bindingClass.tvResult.text = Constance.INGENEER_SALARY
                    bindingClass.imPhoto.setImageResource(R.drawable.engineer)
                }
                else {bindingClass.tvResult.text = infoMsg
                    bindingClass.imPhoto.setImageResource(R.drawable.stop)}
                }

                Constance.DIRECTOR -> {if(pass == Constance.DIRECTOR_PASSWORD){
                    bindingClass.tvResult.text = Constance.DIRECTOR_SALARY
                    bindingClass.imPhoto.setImageResource(R.drawable.director)
                }
                else {bindingClass.tvResult.text = infoMsg
                    bindingClass.imPhoto.setImageResource(R.drawable.stop)}
                }

                else -> {bindingClass.tvResult.text = getString(R.string.elseMsg)
                    bindingClass.imPhoto.setImageResource(R.drawable.stop)}
            }
        }
    }
}