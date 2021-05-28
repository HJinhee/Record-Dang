package com.example.record_dang.presentation.record

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.record_dang.R
import com.example.record_dang.databinding.ActivityFoodAfterBinding

class FoodAfterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFoodAfterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFoodAfterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ivFoodAfterBack.setOnClickListener {
            onBackPressed()
        }
    }
}