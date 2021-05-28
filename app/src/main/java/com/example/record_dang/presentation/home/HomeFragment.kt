package com.example.record_dang.presentation.home

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import com.example.record_dang.R
import com.example.record_dang.data.HomeDataInfo
import com.example.record_dang.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding ?: error("View 를 참조하기위해 binding 이 초기화 되지 않았습니다.")

    private lateinit var homeListAdapter: HomeListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(
            inflater,
            container,
            false
        )

      //  binding.tvHomeUserName.text = arguments?.getString("userName")

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setHomeAdapter()
        setHomeListData()
    }

    private fun setHomeAdapter(){
        // 1. 우리가 사용할 어뎁터의 초기 값을 넣어준다
        homeListAdapter = HomeListAdapter()

        // 2. RecyclerView 에 어뎁터를 우리가 만든 어뎁터로 만들기
        binding.recycleHome.adapter = homeListAdapter
    }

    private fun setHomeListData(){
        homeListAdapter.dataList.addAll(
            listOf<HomeDataInfo>(
                HomeDataInfo(
                    title = "걷기",
                    etc = "",
                    context = "30",
                    unit = "분"
                ),
                HomeDataInfo(
                    title = "혈당",
                    etc = "아침",
                    context = "120",
                    unit = "mg/dL"
                )
            )
        )

        homeListAdapter.notifyDataSetChanged()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}