package com.example.demoandroidapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.demoandroidapp.databinding.ActivityDemoBinding

class DemoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDemoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar!!.hide()

        binding = ActivityDemoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val searchView = binding.searchView
        val textView = binding.textView

        binding.searchButton.setOnClickListener {
            textView.text = searchView.query.toString().trim()
        }

        moveToBasicActivity()
        moveToMainActivity()
    }

    private fun clearSearch() {
        val clearSearchButton = findViewById<Button>(R.id.clear_button)

    }

    private fun moveToBasicActivity() {
        val button = findViewById<Button>(R.id.jump_to_basic_activity)
        button.setOnClickListener {
            finish()
        }
    }

    private fun moveToMainActivity() {
        val button = findViewById<Button>(R.id.jump_to_main_activity1)
        button.setOnClickListener {
            intent = Intent(this@DemoActivity, MainActivity::class.java)
            startActivity(intent)
        }
    }
}