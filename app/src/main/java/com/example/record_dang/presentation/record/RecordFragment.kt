package com.example.record_dang.presentation.record

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.record_dang.databinding.FragmentRecordBinding
import com.example.record_dang.presentation.record.blood.BloodActivity
import com.example.record_dang.presentation.record.exercise.ExerciseActivity
import com.example.record_dang.presentation.record.food.FoodABActivity
import com.example.record_dang.presentation.record.medi.MediActivity

class RecordFragment : Fragment() {

    private lateinit var binding: FragmentRecordBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRecordBinding.inflate(
            inflater,
            container,
            false
        )
        binding.btnRecordFood.setOnClickListener {
            activity?.let{
                val intent = Intent(this.context, FoodABActivity::class.java)
                startActivity(intent)
                Log.d("tag","성공")
            }
        }

        binding.btnRecordExercise.setOnClickListener {
            activity?.let{
                val intent = Intent(this.context, ExerciseActivity::class.java)
                startActivity(intent)
                Log.d("tag","성공")
            }
        }

        binding.btnRecordBlood.setOnClickListener {
            activity?.let{
                val intent = Intent(this.context, BloodActivity::class.java)
                startActivity(intent)
                Log.d("tag","성공")
            }
        }

        binding.btnRecordMedi.setOnClickListener {
            activity?.let{
                val intent = Intent(this.context, MediActivity::class.java)
                startActivity(intent)
                Log.d("tag","성공")
            }
        }






        return binding.root
    }
}