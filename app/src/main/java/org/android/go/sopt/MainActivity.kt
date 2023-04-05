package org.android.go.sopt

import android.view.MotionEvent
import android.content.Context
import android.content.Intent
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import org.android.go.sopt.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private var mBinding:ActivityMainBinding? = null
    private val binding get() = mBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val tv_6 = findViewById<Button>(R.id.tv_6)

        val tv_3 = findViewById<EditText>(R.id.tv_3)

        val tv_5 = findViewById<EditText>(R.id.tv_5)


        tv_6.setOnClickListener{


            val a_2 = findViewById<TextView>(R.id.a_2)
            val a_3 = findViewById<TextView>(R.id.a_3)
            val id = tv_3.text.toString()
            val pw = tv_5.text.toString()

            val sharedPreference = getSharedPreferences("other", 0)
            val editor = sharedPreference.edit()

            editor.putString("id", id)
            editor.putString("mbti", pw)

            editor.apply()


            val intent = Intent(this, Hi3::class.java)

            intent.putExtra("id", id)

            intent.putExtra("mbti", pw)

            startActivity(intent)


            if((id.length >= 6) && (id.length<=10)) {

                startActivity(intent)

            }


        }

        val tv_7 = findViewById<Button>(R.id.tv_7)

        fun MovePage2() {

            val intent = Intent(this, Hi2::class.java)

            startActivity(intent)

        }

        tv_7.setOnClickListener{

            MovePage2()

        }

    }


    override fun onTouchEvent(event: MotionEvent): Boolean {

        val imm: InputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager

        imm.hideSoftInputFromWindow(currentFocus?.windowToken, 0)

        return true

    }

}