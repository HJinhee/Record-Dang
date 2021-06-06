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
    var totalBlood = 420
    var hbamg = 0
    var hbaper = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBloodBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ivBloodBack.setOnClickListener {
            onBackPressed()
        }

        setBloodCheckTime()



        binding.btnBloodOk.setOnClickListener {
            totalBlood += binding.etBlood.text.toString().toInt()
            hbamg = (totalBlood / 4)
            danger()
            binding.textAverageBlood.text = hbaper.toString()
        }





    }


    private fun setBloodCheckTime(){
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
    private fun danger(){
        when {
            hbamg < 111 -> {
                hbaper = 5.0
                binding.textMyDanger.text = "정상"

            }
            hbamg < 126 -> {
                hbaper = 5.5
                binding.textMyDanger.text = "정상"
            }
            hbamg < 140 -> {
                hbaper = 6.0
                binding.textMyDanger.text = "정상"
            }
            hbamg < 154 -> {
                hbaper = 6.5
                binding.textMyDanger.text = "당뇨병"
            }
            hbamg < 169 -> {
                hbaper = 7.0
                binding.textMyDanger.text = "당뇨병"
            }
            hbamg < 183 -> {
                hbaper = 7.5
                binding.textMyDanger.text = "합병증 위험"
            }
            hbamg < 197 -> {
                hbaper = 8.0
                binding.textMyDanger.text = "합병증 위험"
            }
            hbamg < 215 -> {
                hbaper = 8.5
                binding.textMyDanger.text = "합병증 위험"
            }
            hbamg < 226 -> {
                hbaper = 9.0
                binding.textMyDanger.text = "합병증 위험"
            }
            hbamg < 240 -> {
                hbaper = 9.5
                binding.textMyDanger.text = "합병증 위험 높음"
            }
            hbamg < 255 -> {
                hbaper = 10.0
                binding.textMyDanger.text = "합병증 위험 높음"
            }
            hbamg < 269 -> {
                hbaper = 10.5
                binding.textMyDanger.text = "합병증 위험 높음"
            }
            hbamg < 283 -> {
                hbaper = 11.0
                binding.textMyDanger.text = "합병증 위험 높음"
            }
            hbamg < 298 -> {
                hbaper = 11.5
                binding.textMyDanger.text = "합병증 위험 높음"
            }
            hbamg < 312 -> {
                hbaper = 12.0
                binding.textMyDanger.text = "합병증 위험 높음"
            }
            hbamg < 326 -> {
                hbaper = 12.5
                binding.textMyDanger.text = "합병증 위험 높음"
            }
            hbamg < 341 -> {
                hbaper = 13.0
                binding.textMyDanger.text = "합병증 위험 높음"
            }
            hbamg < 355 -> {
                hbaper = 13.5
                binding.textMyDanger.text = "합병증 위험 높음"
            }
            else -> {
                hbaper = 14.0
                binding.textMyDanger.text = "합병증 위험 높음"
            }
        }
    }
}