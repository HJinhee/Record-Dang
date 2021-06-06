package com.example.record_dang.presentation.record.exercise

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.record_dang.data.RecordExerciseInfo
import com.example.record_dang.data.RecordFoodInfo
import com.example.record_dang.databinding.ItemRecordAfterFoodBinding
import com.example.record_dang.databinding.ItemRecordExerciseBinding

class ExerciseListAdapter : RecyclerView.Adapter<ExerciseListAdapter.ExerciseViewHolder>() {

    /* 2. Adapter 는 ViewHolder 로 변경할 Data 를 가지고 있어야함 */
    val exerciseList = mutableListOf<RecordExerciseInfo>()

    // 3. Adapter 는 아이템마다 ViewHolder를 만드는 방법을 정의
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExerciseViewHolder {
        val binding = ItemRecordExerciseBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ExerciseViewHolder(binding)
    }

    // 4. Adapter 는 전체 아이템의 수를 알아야 함
    override fun getItemCount(): Int = exerciseList.size

    // 5. Adapter 는 ViewHolder 에 Data 를 전달하는 방법을 정의
    override fun onBindViewHolder(holder: ExerciseViewHolder, position: Int) {
        holder.onBind(exerciseList[position])
    }

    class ExerciseViewHolder(
        private val binding: ItemRecordExerciseBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(recordExerciseInfo: RecordExerciseInfo) {
            binding.recordExerciseData = recordExerciseInfo

        }
    }
}