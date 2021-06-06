package com.example.record_dang.presentation.record.blood

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.example.record_dang.R
import com.example.record_dang.databinding.ActivityBloodBinding

class BloodActivity : AppCompatActivity(){
    private lateinit var binding: ActivityBloodBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBloodBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ivBloodBack.setOnClickListener {
            onBackPressed()
        }

        val items = resources.getStringArray(R.array.blood_time_array)
        val myAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, items)

        binding.bloodTimeSpinner.adapter = myAdapter

        binding.bloodTimeSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {

                //아이템이 클릭 되면 맨 위부터 position 0번부터 순서대로 동작하게 됩니다.
                when(position) {
                    //아침 전
                    0   ->  {

                    }
                    //아침 후
                    1   ->  {

                    }
                    //점심 전
                    2   ->  {

                    }
                    //점심 후
                    3   ->  {

                    }
                    //저녁 전
                    4   ->  {

                    }
                    //저녁 후
                    5   ->  {

                    }
                    //자기 전
                    6   ->  {

                    }
                    //기타
                    7   ->  {

                    }
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>) {

            }
        }
    }
}