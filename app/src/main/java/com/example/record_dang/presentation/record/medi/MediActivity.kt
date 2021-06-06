package com.example.record_dang.presentation.record.medi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.record_dang.data.RecordExerciseInfo
import com.example.record_dang.data.RecordMediInfo
import com.example.record_dang.databinding.ActivityExerciseBinding
import com.example.record_dang.databinding.ActivityMediBinding
import com.example.record_dang.presentation.record.exercise.ExerciseListAdapter

class MediActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMediBinding
    private lateinit var mediListAdapter: MediListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMediBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ivMediBack.setOnClickListener {
            onBackPressed()
        }

        binding.btnAddMedi.setOnClickListener {
            addMediListData()
        }

        setMediAdapter()
        setMediListData()
    }


    private fun setMediAdapter(){
        // 1. 우리가 사용할 어뎁터의 초기 값을 넣어준다
        mediListAdapter = MediListAdapter()

        // 2. RecyclerView 에 어뎁터를 우리가 만든 어뎁터로 만들기
        binding.recyclerviewRecordMedi.adapter = mediListAdapter

    }

    private fun setMediListData(){
        mediListAdapter.mediList.addAll(
            listOf<RecordMediInfo>(
                RecordMediInfo(
                    mediName = "감기약",
                    mediTime = "아침",
                    mediLocation = "",
                    mediCount = "1회"
                )
            )
        )

        mediListAdapter.notifyDataSetChanged()
    }

    private fun addMediListData(){
        mediListAdapter.mediList.addAll(
            listOf<RecordMediInfo>(
                RecordMediInfo(
                    mediName = "",
                    mediTime = "",
                    mediLocation = "",
                    mediCount = ""
                )
            )
        )

        mediListAdapter.notifyDataSetChanged()
    }

}