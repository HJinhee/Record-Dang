package com.example.record_dang.presentation.record.food

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.record_dang.data.RecordExerciseInfo
import com.example.record_dang.data.RecordFoodInfo
import com.example.record_dang.databinding.ActivityFoodAfterBinding

class FoodAfterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFoodAfterBinding
    private lateinit var foodAfterListAdapter: FoodAfterListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFoodAfterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ivFoodAfterBack.setOnClickListener {
            onBackPressed()
        }

        binding.foodAfterSave.setOnClickListener {
            Toast.makeText(this,"저장되었습니다.", Toast.LENGTH_LONG).show()
            onBackPressed()
        }

        setFoodAfterAdapter()
        //setFoodAfterListData()

        binding.btnAddFood.setOnClickListener { addFoodAfterListData() }
    }


    private fun setFoodAfterAdapter(){
        // 1. 우리가 사용할 어뎁터의 초기 값을 넣어준다
        foodAfterListAdapter = FoodAfterListAdapter()

        // 2. RecyclerView 에 어뎁터를 우리가 만든 어뎁터로 만들기
        binding.recyclerviewRecordFood.adapter = foodAfterListAdapter

    }

    private fun setFoodAfterListData(){
        foodAfterListAdapter.foodList.addAll(
            listOf<RecordFoodInfo>(
                RecordFoodInfo(
                    foodName = "된찌",
                    foodKcal = "200",
                ),
                RecordFoodInfo(
                    foodName = "된찌",
                    foodKcal = "200"
                ),
                RecordFoodInfo(
                    foodName = "된찌",
                    foodKcal = "200"
                )
            )
        )

        foodAfterListAdapter.notifyDataSetChanged()
    }

    private fun addFoodAfterListData(){
        foodAfterListAdapter.foodList.addAll(
            listOf<RecordFoodInfo>(
                RecordFoodInfo(
                    foodName = "",
                    foodKcal = "",
                )
            )
        )

        foodAfterListAdapter.notifyDataSetChanged()
    }

}