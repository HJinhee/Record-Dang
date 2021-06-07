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
            setDayChart()
        }

        binding.btnWeekGraph.setOnClickListener {
            setWeekChart()
        }

        binding.btnMonthGraph.setOnClickListener {
            setMonthChart()
        }

        return binding.root
    }

    private fun setWeekChart() {
        binding.weekChart.visibility = View.GONE
        binding.dayChart.visibility = View.VISIBLE

        val morning = ArrayList<BarEntry>()
        val lunch = ArrayList<BarEntry>()
        val dinner = ArrayList<BarEntry>()
        val etc = ArrayList<BarEntry>()

        morning.add(BarEntry(0f, 120f))
        morning.add(BarEntry(1f, 130f))
        morning.add(BarEntry(2f, 120f))
        morning.add(BarEntry(3f, 140f))
        morning.add(BarEntry(4f, 150f))
        morning.add(BarEntry(5f, 100f))
        morning.add(BarEntry(6f, 140f))


        lunch.add(BarEntry(0f, 130f))
        lunch.add(BarEntry(1f, 145f))
        lunch.add(BarEntry(2f, 139f))
        lunch.add(BarEntry(3f, 140f))
        lunch.add(BarEntry(4f, 120f))
        lunch.add(BarEntry(5f, 118f))
        lunch.add(BarEntry(6f, 127f))

        dinner.add(BarEntry(0f, 110f))
        dinner.add(BarEntry(1f, 120f))
        dinner.add(BarEntry(2f, 140f))
        dinner.add(BarEntry(3f, 130f))
        dinner.add(BarEntry(4f, 125f))
        dinner.add(BarEntry(5f, 113f))
        dinner.add(BarEntry(6f, 129f))

        etc.add(BarEntry(0f, 119f))
        etc.add(BarEntry(1f, 139f))
        etc.add(BarEntry(2f, 130f))
        etc.add(BarEntry(3f, 100f))
        etc.add(BarEntry(4f, 109f))
        etc.add(BarEntry(5f, 99f))
        etc.add(BarEntry(11f, 138f))

        var graphArr = ArrayList<IBarDataSet>()
        var bds1 = BarDataSet(morning, "아침")
        bds1.color = resources.getColor(R.color.light_green_1)
        var bds2 = BarDataSet(lunch, "점심")
        bds2.color = resources.getColor(R.color.light_yellow)
        var bds3 = BarDataSet(dinner, "저녁")
        bds3.color = resources.getColor(R.color.skyblue)
        var bds4 = BarDataSet(etc, "기타")
        bds4.color = resources.getColor(R.color.pink)

        graphArr.add(bds1)
        graphArr.add(bds2)
        graphArr.add(bds3)
        graphArr.add(bds4)

        var data = BarData(graphArr)
        data.barWidth = 0.3f

        binding.dayChart!!.data = data
        binding.dayChart!!.invalidate()
        binding.dayChart!!.groupBars(0.02f, 0.3f, 0.02f)

        binding.dayChart.animateY(1000)
    }


    private fun setDayChart(){
        binding.weekChart.visibility = View.GONE
        binding.dayChart.visibility = View.VISIBLE

        val morningBef = ArrayList<BarEntry>()
        val morningAft = ArrayList<BarEntry>()
        val lunchBef = ArrayList<BarEntry>()
        val lunchAft = ArrayList<BarEntry>()
        val dinnerBef = ArrayList<BarEntry>()
        val dinnerAft = ArrayList<BarEntry>()
        val sleep = ArrayList<BarEntry>()
        val etc = ArrayList<BarEntry>()

        morningBef.add(BarEntry(0f, 120f))
        morningAft.add(BarEntry(1f, 140f))
        lunchBef.add(BarEntry(2f, 130f))
        lunchAft.add(BarEntry(3f, 145f))
        dinnerBef.add(BarEntry(4f, 110f))
        dinnerAft.add(BarEntry(5f, 120f))
        sleep.add(BarEntry(6f, 115f))
        etc.add(BarEntry(7f, 119f))

        var graphArr = ArrayList<IBarDataSet>()
        var bds1 = BarDataSet(morningBef, "아침 전")
        bds1.color = resources.getColor(R.color.light_green_2)
        var bds2 = BarDataSet(morningAft, "아침 후")
        bds2.color = resources.getColor(R.color.light_green_1)
        var bds3 = BarDataSet(lunchBef, "점심 전")
        bds3.color = resources.getColor(R.color.light_yellow)
        var bds4 = BarDataSet(lunchAft, "점심 후")
        bds4.color = resources.getColor(R.color.yellow)
        var bds5 = BarDataSet(dinnerBef, "저녁 전")
        bds5.color = resources.getColor(R.color.blue)
        var bds6 = BarDataSet(dinnerAft, "저녁 후")
        bds6.color = resources.getColor(R.color.skyblue)
        var bds7 = BarDataSet(sleep, "자기 전")
        bds7.color = resources.getColor(R.color.pink)
        var bds8 = BarDataSet(etc, "기타")
        bds8.color = resources.getColor(R.color.dark_pink)

        graphArr.add(bds1)
        graphArr.add(bds2)
        graphArr.add(bds3)
        graphArr.add(bds4)
        graphArr.add(bds5)
        graphArr.add(bds6)
        graphArr.add(bds7)
        graphArr.add(bds8)

        var data = BarData(graphArr)
        data.barWidth = 0.6f

        binding.dayChart!!.data = data
        binding.dayChart!!.invalidate()
        binding.dayChart!!.groupBars(0.02f, 0.5f, 0.2f)

        binding.dayChart.animateY(1000)
    }

    private fun setMonthChart(){
        binding.dayChart.visibility = View.GONE
        binding.weekChart.visibility = View.VISIBLE

        val entries = ArrayList<Entry>()
        entries.add(Entry(1f, 130f))
        entries.add(Entry(2f, 140f))
        entries.add(Entry(3f, 135f))
        entries.add(Entry(4f, 128f))
        entries.add(Entry(5f, 133f))
        entries.add(Entry(6f, 118f))
        entries.add(Entry(7f, 128f))
        entries.add(Entry(8f, 120f))
        entries.add(Entry(9f, 136f))
        entries.add(Entry(10f, 130f))
        entries.add(Entry(11f, 123f))
        entries.add(Entry(12f, 129f))

        val labels = ArrayList<String>()
        labels.add("Jan")
        labels.add("Feb")
        labels.add("Mar")
        labels.add("Apr")
        labels.add("May")
        labels.add("Jun")
        labels.add("Jul")
        labels.add("Aug")
        labels.add("Sep")
        labels.add("Oct")
        labels.add("Nov")
        labels.add("Dec")
        val lineDataSet = LineDataSet(entries, labels.toString())

        val data = LineData(lineDataSet)
        binding.weekChart.data = data // set the data and list of lables into chart
        lineDataSet.color = resources.getColor(R.color.blue)
        binding.weekChart.animateY(1000)

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