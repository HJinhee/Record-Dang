package com.example.record_dang.presentation.record

import android.os.Bundle
import android.util.Log
import android.util.TypedValue
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.record_dang.R
import com.example.record_dang.data.UserFoodRecoInfo
import com.example.record_dang.databinding.ActivityFoodBeforeBinding
import com.example.record_dang.databinding.DialogIngredBinding
import com.google.android.material.chip.Chip


class FoodBeforeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFoodBeforeBinding
    private lateinit var bindingDialog: DialogIngredBinding

    private lateinit var foodBeforeListAdapter: FoodBeforeListAdapter

    var arr = listOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFoodBeforeBinding.inflate(layoutInflater)
        bindingDialog = DialogIngredBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ivFoodBeforeBack.setOnClickListener {
            onBackPressed()
        }

        setFoodBeforeAdapter()
        radioCheck()

        val dlg = AlertDialog.Builder(this).create()
        dlg.setView(bindingDialog.root)

        bindingDialog.ivAddTextIngres.setOnClickListener {
            bindingDialog.textUserIngred.text =
                bindingDialog.textUserIngred.text.toString() + " " + bindingDialog.etUserIngred.text.toString()
        }

        binding.ivAddIngred.setOnClickListener {
            bindingDialog.ok.setOnClickListener {
                val str = bindingDialog.textUserIngred.text

                arr = str.split(" ")
                Log.d("tag", arr.toString())
                setCategoryChips(arr)

                dlg.dismiss()
            }

            bindingDialog.cancel.setOnClickListener {
                dlg.dismiss()
            }

            dlg.show()
        }

    }

    fun radioCheck() {
        binding.radioGroup.setOnCheckedChangeListener { radiogroup, checkedId ->
            when (checkedId) {
                R.id.food_before_radio_refri -> {
                    binding.clFoodYesRefi.visibility = View.VISIBLE
                    binding.clFoodNoRefi.visibility = View.GONE
                    setFoodBefRefListData()
                }
                R.id.food_before_radio_default -> {
                    binding.clFoodNoRefi.visibility = View.VISIBLE
                    binding.clFoodYesRefi.visibility = View.GONE
                    setFoodBefDefListData()
                }
            }
        }
    }


    fun setCategoryChips(categorys: List<String>) {
        for (i in 1 until categorys.count()) {
            val mChip =
                this.layoutInflater.inflate(R.layout.item_chip_ingred, null, false) as Chip
            mChip.text = categorys[i]
            val paddingDp = TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP, 10f,
                resources.displayMetrics
            ).toInt()
            mChip.setPadding(paddingDp, 0, paddingDp, 0)
            mChip.setOnCheckedChangeListener { compoundButton, b -> }
            binding.chipsGroupIngred.addView(mChip)

        }
    }

    private fun setFoodBeforeAdapter(){
        // 1. 우리가 사용할 어뎁터의 초기 값을 넣어준다
        foodBeforeListAdapter = FoodBeforeListAdapter()

    }

    private fun setFoodBefRefListData(){
        // 2. RecyclerView 에 어뎁터를 우리가 만든 어뎁터로 만들기
        binding.recyclerviewRecommendRefri.adapter = foodBeforeListAdapter
        foodBeforeListAdapter.foodList.removeAll(listOf<UserFoodRecoInfo>())
        foodBeforeListAdapter.foodList.addAll(
            listOf<UserFoodRecoInfo>(
                UserFoodRecoInfo(
                    checked = false,
                    foodName = "된찌"
                ),
                UserFoodRecoInfo(
                    checked = true,
                    foodName = "밥"
                ),
                UserFoodRecoInfo(
                    checked = false,
                    foodName = "고기"
                )
            )
        )

        foodBeforeListAdapter.notifyDataSetChanged()
    }

    private fun setFoodBefDefListData(){
        // 2. RecyclerView 에 어뎁터를 우리가 만든 어뎁터로 만들기
        binding.recyclerviewRecommendDefault.adapter = foodBeforeListAdapter
        foodBeforeListAdapter.foodList.removeAll(listOf<UserFoodRecoInfo>())

        foodBeforeListAdapter.foodList.addAll(
            listOf<UserFoodRecoInfo>(
                UserFoodRecoInfo(
                    checked = false,
                    foodName = "된장찌개"
                ),
                UserFoodRecoInfo(
                    checked = true,
                    foodName = "밥"
                ),
                UserFoodRecoInfo(
                    checked = false,
                    foodName = "고기"
                )
            )
        )

        foodBeforeListAdapter.notifyDataSetChanged()
    }
}