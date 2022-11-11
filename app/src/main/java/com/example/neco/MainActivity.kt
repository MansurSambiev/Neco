package com.example.neco

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.neco.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var bindingClass : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)

        bindingClass.signIn.setOnClickListener {
            val i = Intent(this, SecondActivity::class.java)
            i.putExtra(Constance.SiGN_STATE, Constance.SiGN_IN_STATE)
            startActivityForResult(i, Constance.REQUEST_CODE_SIGN_IN)
        }

        bindingClass.signUp.setOnClickListener{
            val i = Intent(this, SecondActivity::class.java)
            i.putExtra(Constance.SiGN_STATE, Constance.SiGN_UP_STATE)
            startActivityForResult(i, Constance.REQUEST_CODE_SIGN_UP)
        }

        bindingClass.quit.setOnClickListener{
            bindingClass.tvMainInfo.text = ""
            bindingClass.signUp.visibility = View.VISIBLE
            bindingClass.signIn.visibility = View.VISIBLE
            bindingClass.quit.visibility = View.INVISIBLE

        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
            bindingClass.signUp.visibility = View.INVISIBLE
            bindingClass.signIn.visibility = View.INVISIBLE
            bindingClass.quit.visibility = View.VISIBLE
            bindingClass.tvMainInfo.text = data!!.getStringExtra("answer")

    }


}