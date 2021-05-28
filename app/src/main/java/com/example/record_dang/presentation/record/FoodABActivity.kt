package com.example.record_dang.presentation.record

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.record_dang.R
import com.example.record_dang.databinding.ActivityFoodAbBinding

class FoodABActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFoodAbBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFoodAbBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ivFoodAbBack.setOnClickListener {
            onBackPressed()
        }

        binding.btnFoodAfter.setOnClickListener{
            val intent = Intent(this,FoodAfterActivity::class.java)
            startActivity(intent)
        }

        binding.btnFoodBefore.setOnClickListener{
            val intent = Intent(this,FoodBeforeActivity::class.java)
            startActivity(intent)
        }


    }
}