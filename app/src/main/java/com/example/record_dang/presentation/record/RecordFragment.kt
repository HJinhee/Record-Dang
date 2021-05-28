package com.example.record_dang.presentation.record

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.record_dang.databinding.FragmentRecordBinding

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
        return binding.root
    }
}