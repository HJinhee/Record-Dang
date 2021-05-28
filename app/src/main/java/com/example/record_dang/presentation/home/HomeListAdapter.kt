package com.example.record_dang.presentation.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.record_dang.data.HomeDataInfo
import com.example.record_dang.databinding.ItemHomeBinding

class HomeListAdapter : RecyclerView.Adapter<HomeListAdapter.HomeViewHolder>() {

    /* 2. Adapter 는 ViewHolder 로 변경할 Data 를 가지고 있어야함 */
    val dataList = mutableListOf<HomeDataInfo>()

    // 3. Adapter 는 아이템마다 ViewHolder를 만드는 방법을 정의
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeListAdapter.HomeViewHolder {
        val binding = ItemHomeBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return HomeListAdapter.HomeViewHolder(binding)
    }

    // 4. Adapter 는 전체 아이템의 수를 알아야 함
    override fun getItemCount(): Int = dataList.size

    // 5. Adapter 는 ViewHolder 에 Data 를 전달하는 방법을 정의
    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.onBind(dataList[position])
    }

    class HomeViewHolder(
        private val binding: ItemHomeBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(homeDataInfo: HomeDataInfo) {
            binding.homeData = homeDataInfo
        }
    }
}
