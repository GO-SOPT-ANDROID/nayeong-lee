package org.android.go.sopt

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.Toast

class Hi2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hi2)

        val bt_8 = findViewById<Button>(R.id.bt_8)


        fun MovePage3() {

            Toast.makeText(this@Hi2,"회원가입이 완료됐습니다!", Toast.LENGTH_SHORT).show()

            val intent = Intent(this, MainActivity::class.java)

            startActivity(intent)

        }

        bt_8.setOnClickListener{

            MovePage3()

        }

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