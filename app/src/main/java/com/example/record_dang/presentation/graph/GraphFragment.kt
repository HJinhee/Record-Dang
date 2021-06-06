package com.example.record_dang.presentation.graph

import android.os.Bundle
import android.os.SystemClock
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.record_dang.R
import com.example.record_dang.databinding.FragmentGraphBinding
import com.github.mikephil.charting.data.*
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet

class GraphFragment : Fragment() {

    var isRunning = false

    private var _binding: FragmentGraphBinding? = null
    private val binding get() = _binding ?: error("View 를 참조하기위해 binding 이 초기화 되지 않았습니다.")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentGraphBinding.inflate(
            inflater,
            container,
            false
        )

//        binding.btnDayGraph.setOnClickListener {
//            if (isRunning == false) {
//                isRunning = true
//                binding.btnDayGraph.text = "그래프 구현중"
//                binding.btnDayGraph.isClickable = false
//                val thread = ThreadClass()
//                thread.start()
//            }
//        }

        binding.btnDayGraph.setOnClickListener {
            setBarChart()
        }

        binding.btnWeekGraph.setOnClickListener {
            setGroupChart()
        }
        return binding.root
    }

    private fun setBarChart() {
        val entries = ArrayList<BarEntry>()
        entries.add(BarEntry(8f, 0f))
        entries.add(BarEntry(2f, 1f))
        entries.add(BarEntry(5f, 2f))
        entries.add(BarEntry(20f, 3f))
        entries.add(BarEntry(15f, 4f))
        entries.add(BarEntry(19f, 5f))
        val barDataSet = BarDataSet(entries, "Cells")
        val labels = ArrayList<String>()
        labels.add("18-Jan")
        labels.add("19-Jan")
        labels.add("20-Jan")
        labels.add("21-Jan")
        labels.add("22-Jan")
        labels.add("23-Jan")
        val data = BarData(barDataSet)
        binding.dayChart.data = data // set the data and list of lables into chart
        barDataSet.color = resources.getColor(R.color.light_green_2)
        binding.dayChart.animateY(5000)
    }

    private fun setGroupChart(){
        val entry1 = ArrayList<BarEntry>()
        val entry2 = ArrayList<BarEntry>()

        entry1.add(BarEntry(0f, 12f))
        entry1.add(BarEntry(20f, 12f))

        entry2.add(BarEntry(0f, 15f))
        entry2.add(BarEntry(0f, 35f))

        var graphArr = ArrayList<IBarDataSet>()
        var bds1 = BarDataSet(entry1, "Entry 1")
        bds1.color = resources.getColor(R.color.light_yellow)


        var bds2 = BarDataSet(entry2, "Entry 2")
        bds2.color = resources.getColor(R.color.light_green_2)

        graphArr.add(bds1)
        graphArr.add(bds2)

        var data = BarData(graphArr)

        binding.dayChart!!.data = data
        binding.dayChart!!.invalidate()
        binding.dayChart!!.groupBars(0.2f, 0.5f, 0.02f)


    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

//    inner class ThreadClass : Thread() {
//        override fun run() {
//            val input = Array<Double>(200, { Math.random() })
//
//            // 그래프 초기값 설정은 이곳에 //
//            val input = Array<Double>(100,{Math.random()})
//            // Entry 배열 생성
//            var entries: ArrayList<Entry> = ArrayList()
//            // Entry 배열 초기값 입력
//            entries.add(Entry(0F , 0F))
//            // 그래프 구현을 위한 LineDataSet 생성
//            var dataset: LineDataSet = LineDataSet(entries, "input")
//            // 그래프 data 생성 -> 최종 입력 데이터
//            var data: LineData = LineData(dataset)
//            // chart.xml에 배치된 lineChart에 데이터 연결
//            binding.dayChart.data = data
//
//            runOnUiThread {
//                // 그래프 생성
//                binding.dayChart.animateXY(1, 1)
//            }
//
//            for (i in 0 until input.size) {
//                // 그래프 표현식은 이곳에 //
//                SystemClock.sleep(10)
//                data.addEntry(Entry(i.toFloat(), input[i].toFloat()), 0)
//                data.notifyDataChanged()
//                binding.dayChart.notifyDataSetChanged()
//                binding.dayChart.invalidate()
//            }
//            binding.btnDayGraph.text = "난수 생성 시작"
//            binding.btnDayGraph.isClickable = true
//
//            isRunning = false
//        }
//    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}