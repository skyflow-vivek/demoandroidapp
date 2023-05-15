package com.example.demoandroidapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.demoandroidapp.databinding.ActivityBasicBinding
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.Toast

class BasicActivity : AppCompatActivity() {

    //    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityBasicBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityBasicBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            val inputValue: String = binding.editText.text.toString()
            if (inputValue.trim() == "") {
                Toast.makeText(
                    this, "please input data, edit text cannot be blank", Toast.LENGTH_LONG
                ).show()
            } else {
                binding.textView4.setText(inputValue).toString()
            }
        }

        binding.textView5.setOnClickListener {
            if (binding.textView4.text.toString()
                    .trim() == ""
            ) {
                Toast.makeText(
                    this,
                    "clicked on reset textView,\n output textView already reset",
                    Toast.LENGTH_LONG
                ).show()
            } else {
                binding.textView4.setText("").toString()
            }
        }

        binding.editText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                //  TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                Toast.makeText(
                    applicationContext,
                    "executed before making any change over EditText",
                    Toast.LENGTH_SHORT
                ).show()
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                //  TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                Toast.makeText(
                    applicationContext,
                    "executed while making any change over EditText",
                    Toast.LENGTH_SHORT
                ).show()
            }

            override fun afterTextChanged(p0: Editable?) {
                //  TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                Toast.makeText(
                    applicationContext,
                    "executed after change made over EditText",
                    Toast.LENGTH_SHORT
                ).show()
            }
        })

        moveToMainActivity()
        moveToDemoActivity()
    }

    private fun moveToMainActivity() {
        val button = findViewById<Button>(R.id.jump_to_main_activity)
        button.setOnClickListener {
            intent = Intent(this@BasicActivity, MainActivity::class.java)
            intent.putExtra("text_value", binding.editText.text.toString())
            startActivity(intent)
        }
    }
    private fun moveToDemoActivity() {
        val button = findViewById<Button>(R.id.jump_to_demo)
        button.setOnClickListener {
            intent = Intent(this@BasicActivity, DemoActivity::class.java)
            startActivity(intent)
        }
    }

    private fun random(){
        println("random function")
    }

    // imagine new function here
}