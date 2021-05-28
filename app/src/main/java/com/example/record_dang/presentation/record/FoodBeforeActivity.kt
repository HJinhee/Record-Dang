package com.example.record_dang.presentation.record

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.record_dang.R
import com.example.record_dang.databinding.ActivityFoodBeforeBinding

class FoodBeforeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFoodBeforeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFoodBeforeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ivFoodBeforeBack.setOnClickListener {
            onBackPressed()
        }





    }
}