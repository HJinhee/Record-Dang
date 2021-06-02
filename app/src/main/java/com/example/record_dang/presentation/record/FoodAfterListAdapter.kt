package com.example.record_dang.presentation.record;

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.record_dang.data.RecordFoodInfo
import com.example.record_dang.databinding.ItemRecordAfterFoodBinding


class FoodAfterListAdapter : RecyclerView.Adapter<FoodAfterListAdapter.FoodAfterViewHolder>() {

    /* 2. Adapter 는 ViewHolder 로 변경할 Data 를 가지고 있어야함 */
    val foodList = mutableListOf<RecordFoodInfo>()

    // 3. Adapter 는 아이템마다 ViewHolder를 만드는 방법을 정의
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodAfterViewHolder {
        val binding = ItemRecordAfterFoodBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return FoodAfterViewHolder(binding)
    }

    // 4. Adapter 는 전체 아이템의 수를 알아야 함
    override fun getItemCount(): Int = foodList.size

    // 5. Adapter 는 ViewHolder 에 Data 를 전달하는 방법을 정의
    override fun onBindViewHolder(holder: FoodAfterViewHolder, position: Int) {
        holder.onBind(foodList[position])
    }

    class FoodAfterViewHolder(
        private val binding: ItemRecordAfterFoodBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(recordFoodInfo: RecordFoodInfo) {
            binding.recordFoodData = recordFoodInfo
        }
    }
}