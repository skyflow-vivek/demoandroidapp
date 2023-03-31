package com.example.demoandroidapp.skyflow.poc.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.demoandroidapp.databinding.ActivityCollectBinding

class CollectActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCollectBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCollectBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

    }

}