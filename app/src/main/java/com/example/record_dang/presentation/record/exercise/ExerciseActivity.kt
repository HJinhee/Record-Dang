package com.example.record_dang.presentation.record.exercise

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.record_dang.databinding.ActivityExerciseBinding

class ExerciseActivity : AppCompatActivity() {

    private lateinit var binding: ActivityExerciseBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExerciseBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ivExerciseBack.setOnClickListener {
            onBackPressed()
        }
    }
}