package com.example.record_dang.presentation.record

import android.os.Bundle
import android.util.Log
import android.util.TypedValue
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.record_dang.R
import com.example.record_dang.databinding.ActivityFoodBeforeBinding
import com.example.record_dang.databinding.DialogIngredBinding
import com.google.android.material.chip.Chip


class FoodBeforeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFoodBeforeBinding
    private lateinit var bindingDialog: DialogIngredBinding

    var arr = listOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFoodBeforeBinding.inflate(layoutInflater)
        bindingDialog = DialogIngredBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ivFoodBeforeBack.setOnClickListener {
            onBackPressed()
        }

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
                }
                R.id.food_before_radio_default -> {
                    binding.clFoodNoRefi.visibility = View.VISIBLE
                    binding.clFoodYesRefi.visibility = View.GONE
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
}