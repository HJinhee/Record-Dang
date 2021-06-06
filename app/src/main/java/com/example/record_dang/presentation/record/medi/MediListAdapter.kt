package com.example.record_dang.presentation.record.medi

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.record_dang.data.RecordExerciseInfo
import com.example.record_dang.data.RecordFoodInfo
import com.example.record_dang.data.RecordMediInfo
import com.example.record_dang.databinding.ItemRecordAfterFoodBinding
import com.example.record_dang.databinding.ItemRecordExerciseBinding
import com.example.record_dang.databinding.ItemRecordMediBinding

class MediListAdapter : RecyclerView.Adapter<MediListAdapter.MediViewHolder>() {

    /* 2. Adapter 는 ViewHolder 로 변경할 Data 를 가지고 있어야함 */
    val mediList = mutableListOf<RecordMediInfo>()

    // 3. Adapter 는 아이템마다 ViewHolder를 만드는 방법을 정의
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MediViewHolder {
        val binding = ItemRecordMediBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return MediViewHolder(binding)
    }

    // 4. Adapter 는 전체 아이템의 수를 알아야 함
    override fun getItemCount(): Int = mediList.size

    // 5. Adapter 는 ViewHolder 에 Data 를 전달하는 방법을 정의
    override fun onBindViewHolder(holder: MediViewHolder, position: Int) {
        holder.onBind(mediList[position])
    }

    class MediViewHolder(
        private val binding: ItemRecordMediBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(recordMediInfo: RecordMediInfo) {
            binding.recordMediData = recordMediInfo

        }
    }
}