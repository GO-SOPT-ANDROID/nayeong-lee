package org.android.go.sopt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.Button
import android.widget.TextView
import android.app.Activity
import android.content.Context
import android.view.MotionEvent
import android.view.View
import android.view.inputmethod.InputMethodManager

class Hi3 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hi3)

        val a_2 = findViewById<TextView>(R.id.a_2)
        val a_3 = findViewById<TextView>(R.id.a_3)


        val id = intent.getStringExtra("id")
        val pw = intent.getStringExtra("mbti")

        a_2.text = id
        a_3.text = pw

        fun View.hideKeyboard() {

            val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager

            imm.hideSoftInputFromWindow(windowToken, 0)

        }

    }

    override fun onTouchEvent(event: MotionEvent): Boolean {

        val imm: InputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager

        imm.hideSoftInputFromWindow(currentFocus?.windowToken, 0)

        return true

    }

}