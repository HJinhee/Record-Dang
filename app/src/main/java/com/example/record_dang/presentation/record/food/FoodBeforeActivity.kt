package com.example.record_dang.presentation.record.food

import android.os.Bundle
import android.util.Log
import android.util.TypedValue
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.record_dang.R
import com.example.record_dang.data.UserFoodRecoInfo
import com.example.record_dang.databinding.ActivityFoodBeforeBinding
import com.example.record_dang.databinding.DialogIngredBinding
import com.example.record_dang.databinding.ItemRecordBeforeFoodBinding
import com.google.android.material.chip.Chip
import com.google.android.youtube.player.*


class FoodBeforeActivity : YouTubeBaseActivity(), YouTubePlayer.OnInitializedListener{
    private val TAG = "YoutubeActivity"
    val YOUTUBE_VIDEO_ID = "Evfe8GEn33w"
    val YOUTUBE_PLAYLIST = "UCU3jy5C8MB-JvSw_86SFV2w"

    private lateinit var binding: ActivityFoodBeforeBinding
    private lateinit var bindingDialog: DialogIngredBinding
    private lateinit var bindingItem: ItemRecordBeforeFoodBinding

    private lateinit var foodBeforeListAdapter: FoodBeforeListAdapter



    var arr = listOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFoodBeforeBinding.inflate(layoutInflater)
        bindingDialog = DialogIngredBinding.inflate(layoutInflater)
        bindingItem = ItemRecordBeforeFoodBinding.inflate(layoutInflater)
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

        //binding.youtubeView.initialize("6RQ-bBdASvk", this)

        bindingItem.itemBtnYoutube.setOnClickListener {

            Toast.makeText(this@FoodBeforeActivity, "button click", Toast.LENGTH_SHORT).show()
            initYoutube()

        }

    }

//    public fun onClickYoutube(){
//        initYoutube()
//        Log.d("youtube","click")
//    }

    fun initYoutube(){
        Log.d("youtube","initstart")

//        val layout = layoutInflater.inflate(R.layout.activity_food_before, null) as ConstraintLayout
        val playerView = YouTubePlayerView(this)

        if(YouTubeApiServiceUtil.isYouTubeApiServiceAvailable(this).equals(YouTubeInitializationResult.SUCCESS)){
            //This means that your device has the Youtube API Service (the app) and you are safe to launch it.
            playerView.layoutParams = ConstraintLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
            binding.root.addView(playerView)
            //layout.addView(playerView)

            playerView.initialize(getString(R.string.GOOGLE_API_KEY), this)
            Log.d("youtube","initsuccess")

        }else{
            // Log the outcome, take necessary measure, like playing the video in webview :)
            Log.d("youtube","initfail")
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

    override fun onInitializationSuccess(provider: YouTubePlayer.Provider?, youTubePlayer: YouTubePlayer?,
                                         wasRestored: Boolean) {
        Log.d(TAG, "onInitializationSuccess: provider is ${provider?.javaClass}")
        Log.d(TAG, "onInitializationSuccess: youTubePlayer is ${youTubePlayer?.javaClass}")
        Toast.makeText(this, "Initialized Youtube Player successfully", Toast.LENGTH_SHORT).show()

        youTubePlayer?.setPlayerStateChangeListener(playerStateChangeListener)
        youTubePlayer?.setPlaybackEventListener(playbackEventListener)

        if (!wasRestored) {
            youTubePlayer?.cueVideo(YOUTUBE_VIDEO_ID)
        }
    }

    override fun onInitializationFailure(provider: YouTubePlayer.Provider?,
                                         youTubeInitializationResult: YouTubeInitializationResult?) {
        val REQUEST_CODE = 0

        if (youTubeInitializationResult?.isUserRecoverableError == true) {
            youTubeInitializationResult.getErrorDialog(this, REQUEST_CODE).show()
        } else {
            val errorMessage = "There was an error initializing the YoutubePlayer ($youTubeInitializationResult)"
            Toast.makeText(this, errorMessage, Toast.LENGTH_LONG).show()
            Log.d(TAG, errorMessage)

        }
    }

    private val playbackEventListener = object: YouTubePlayer.PlaybackEventListener {
        override fun onSeekTo(p0: Int) {
        }

        override fun onBuffering(p0: Boolean) {
        }

        override fun onPlaying() {
            Toast.makeText(this@FoodBeforeActivity, "Good, video is playing ok", Toast.LENGTH_SHORT).show()
        }

        override fun onStopped() {
            Toast.makeText(this@FoodBeforeActivity, "Video has stopped", Toast.LENGTH_SHORT).show()
        }

        override fun onPaused() {
            Toast.makeText(this@FoodBeforeActivity, "Video has paused", Toast.LENGTH_SHORT).show()
        }
    }

    private val playerStateChangeListener = object: YouTubePlayer.PlayerStateChangeListener {
        override fun onAdStarted() {
            Toast.makeText(this@FoodBeforeActivity, "Click Ad now, make the video creator rich!", Toast.LENGTH_SHORT).show()
        }

        override fun onLoading() {
        }

        override fun onVideoStarted() {
            Toast.makeText(this@FoodBeforeActivity, "Video has started", Toast.LENGTH_SHORT).show()
        }

        override fun onLoaded(p0: String?) {
        }

        override fun onVideoEnded() {
            Toast.makeText(this@FoodBeforeActivity, "Congratulations! You've completed another video.", Toast.LENGTH_SHORT).show()
        }

        override fun onError(p0: YouTubePlayer.ErrorReason?) {
        }
    }
}