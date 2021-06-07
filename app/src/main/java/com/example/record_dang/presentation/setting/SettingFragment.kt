package com.example.record_dang.presentation.setting

import android.app.NotificationChannel
import android.app.NotificationManager
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.NotificationCompat
import androidx.fragment.app.Fragment
import com.example.record_dang.R
import com.example.record_dang.databinding.FragmentSettingBinding


class SettingFragment : Fragment() {
    private lateinit var binding : FragmentSettingBinding

    var NOTIFICATION_CHANNEL_ID = "234"
    var NOTIFICATION_CHANNEL_NAME = "Record-Dang"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSettingBinding.inflate(
            inflater,
            container,
            false
        )
        // Inflate the layout for this fragment

        var notificationManager1 = context?.getSystemService(NotificationManager::class.java) as NotificationManager?
        var notificationManager2 = context?.getSystemService(NotificationManager::class.java) as NotificationManager?
        var notificationManager3 = context?.getSystemService(NotificationManager::class.java) as NotificationManager?

        binding.settingFoodAlarm1.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked){
               // Toast.makeText(this,"switch on", Toast.LENGTH_SHORT).show()

                val handler = Handler()
                handler.postDelayed(object : Runnable {
                    override fun run() {
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                            val importance = NotificationManager.IMPORTANCE_LOW
                            val notificationChannel = NotificationChannel(
                                NOTIFICATION_CHANNEL_ID,
                                NOTIFICATION_CHANNEL_NAME,
                                importance
                            )
                            notificationChannel.enableLights(true)
                            notificationChannel.lightColor = Color.RED
                            notificationChannel.enableVibration(true)
                            notificationChannel.vibrationPattern =
                                longArrayOf(100, 200, 300, 400, 500, 400, 300, 200, 400)
                            notificationManager1?.createNotificationChannel(notificationChannel)
                        }

                        val mNotificationBuilder: NotificationCompat.Builder =
                            NotificationCompat.Builder(activity!!,NOTIFICATION_CHANNEL_ID)
                                .setSmallIcon(R.mipmap.ic_launcher)
                                .setContentTitle("기록하당")
                                .setContentText("식사 후 1시간 알람이 설정되었습니다.")
                          //      .setAutoCancel(false)

                    notificationManager1!!.notify(0, mNotificationBuilder.build())
                    }
                }, 0)
            }
            else{
               // Toast.makeText(this,"switch off", Toast.LENGTH_SHORT).show()

            }
        }

        binding.settingFoodAlarm2.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked){
                // Toast.makeText(this,"switch on", Toast.LENGTH_SHORT).show()

                val handler = Handler()
                handler.postDelayed(object : Runnable {
                    override fun run() {
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                            val importance = NotificationManager.IMPORTANCE_LOW
                            val notificationChannel = NotificationChannel(
                                NOTIFICATION_CHANNEL_ID,
                                NOTIFICATION_CHANNEL_NAME,
                                importance
                            )
                            notificationChannel.enableLights(true)
                            notificationChannel.lightColor = Color.RED
                            notificationChannel.enableVibration(true)
                            notificationChannel.vibrationPattern =
                                longArrayOf(100, 200, 300, 400, 500, 400, 300, 200, 400)
                            notificationManager2?.createNotificationChannel(notificationChannel)
                        }

                        val mNotificationBuilder: NotificationCompat.Builder =
                            NotificationCompat.Builder(activity!!,NOTIFICATION_CHANNEL_ID)
                                .setSmallIcon(R.mipmap.ic_launcher)
                                .setContentTitle("기록하당")
                                .setContentText("식사 후 2시간 알람이 설정되었습니다.")
                            //    .setAutoCancel(false)

                        notificationManager2!!.notify(0, mNotificationBuilder.build())
                    }
                }, 0)
            }
            else{
                // Toast.makeText(this,"switch off", Toast.LENGTH_SHORT).show()

            }
        }

        binding.settingInsulinAlarm.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked){
                // Toast.makeText(this,"switch on", Toast.LENGTH_SHORT).show()

                val handler = Handler()
                handler.postDelayed(object : Runnable {
                    override fun run() {
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                            val importance = NotificationManager.IMPORTANCE_LOW
                            val notificationChannel = NotificationChannel(
                                NOTIFICATION_CHANNEL_ID,
                                NOTIFICATION_CHANNEL_NAME,
                                importance
                            )
                            notificationChannel.enableLights(true)
                            notificationChannel.lightColor = Color.RED
                            notificationChannel.enableVibration(true)
                            notificationChannel.vibrationPattern =
                                longArrayOf(100, 200, 300, 400, 500, 400, 300, 200, 400)
                            notificationManager3?.createNotificationChannel(notificationChannel)
                        }

                        val mNotificationBuilder: NotificationCompat.Builder =
                            NotificationCompat.Builder(activity!!,NOTIFICATION_CHANNEL_ID)
                                .setSmallIcon(R.mipmap.ic_launcher)
                                .setContentTitle("기록하당")
                                .setContentText("인슐린 주입 유무 알람이 설정되었습니다.")
                               // .setAutoCancel(false)

                        notificationManager3!!.notify(0, mNotificationBuilder.build())
                    }
                }, 0)
            }
            else{
                // Toast.makeText(this,"switch off", Toast.LENGTH_SHORT).show()

            }
        }



        return binding.root
    }
}