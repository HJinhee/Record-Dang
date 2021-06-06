package com.example.record_dang.presentation.record.exercise

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.record_dang.data.RecordExerciseInfo
import com.example.record_dang.data.RecordFoodInfo
import com.example.record_dang.databinding.ActivityExerciseBinding
import com.example.record_dang.databinding.ActivityFoodAfterBinding
import com.example.record_dang.presentation.record.food.FoodAfterListAdapter

class ExerciseActivity : AppCompatActivity() {

    private lateinit var binding: ActivityExerciseBinding
    private lateinit var exerciseListAdapter: ExerciseListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExerciseBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ivExerciseBack.setOnClickListener {
            onBackPressed()
        }

        binding.btnAddExercise.setOnClickListener {
            addExerciseListData()
        }

        setExerciseAdapter()
        setExerciseListData()
    }


    private fun setExerciseAdapter(){
        // 1. 우리가 사용할 어뎁터의 초기 값을 넣어준다
        exerciseListAdapter = ExerciseListAdapter()

        // 2. RecyclerView 에 어뎁터를 우리가 만든 어뎁터로 만들기
        binding.recyclerviewRecordExercise.adapter = exerciseListAdapter

    }

    private fun setExerciseListData(){
        exerciseListAdapter.exerciseList.addAll(
            listOf<RecordExerciseInfo>(
                RecordExerciseInfo(
                    exerciseName = "걷기",
                    exerciseTime = "30분",
                    exerciseDistance = "500m",
                    exerciseKcal = "100kcal"
                ),
                RecordExerciseInfo(
                    exerciseName = "달리기",
                    exerciseTime = "30분",
                    exerciseDistance = "1km",
                    exerciseKcal = "400kcal"
                ),
                RecordExerciseInfo(
                    exerciseName = "등산",
                    exerciseTime = "2시간",
                    exerciseDistance = "4km",
                    exerciseKcal = "1000kcal"
                )
            )
        )

        exerciseListAdapter.notifyDataSetChanged()
    }

    private fun addExerciseListData(){
        exerciseListAdapter.exerciseList.addAll(
            listOf<RecordExerciseInfo>(
                RecordExerciseInfo(
                    exerciseName = "",
                    exerciseTime = "",
                    exerciseDistance = "",
                    exerciseKcal = ""
                )
            )
        )

        exerciseListAdapter.notifyDataSetChanged()
    }

}