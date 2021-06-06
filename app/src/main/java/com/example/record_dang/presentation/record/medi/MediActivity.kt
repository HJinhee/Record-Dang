package com.example.record_dang.presentation.record.medi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.record_dang.databinding.ActivityMediBinding

class MediActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMediBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMediBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ivMediBack.setOnClickListener {
            onBackPressed()
        }
    }
}