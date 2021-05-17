package com.example.record_dang

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.record_dang.databinding.ActivitySignUpBinding
import com.example.record_dang.presentation.home.HomeFragment

class SignUpActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignUpBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.d(CURRENT_ACTIVITY, "Called onCreate")

        signUpButtonClickEvent()

    }

    private fun signUpButtonClickEvent() {
        binding.btnSignUp.setOnClickListener {

            val userName = binding.etSignupName.text
            val userId = binding.etSignupId.text
            val userPw = binding.etSignupPw.text
            if (userName.isNullOrBlank() || userId.isNullOrBlank() || userPw.isNullOrBlank()) {
                Toast.makeText(this@SignUpActivity, "빈 칸이 있는지 확인해주세요", Toast.LENGTH_SHORT)
                    .show()
            } else {
                val intent = Intent(this@SignUpActivity, SignInActivity::class.java)
                intent.putExtra("userName", userName.toString())
                    .putExtra("userId", userId.toString())
                    .putExtra("userPw", userPw.toString())

                setResult(
                    RESULT_OK,
                    intent
                )   //setResult() 메소드로 결과를 저장 -> 성공 : RESULT_OK, 실패 : RESULT_CANCEL
                finish()
            }
        }
    }

    companion object {
        const val CURRENT_ACTIVITY = "SignUpActivity"
    }

    override fun onStart() {
        super.onStart()
        Log.d(CURRENT_ACTIVITY, "Called onStart")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(CURRENT_ACTIVITY, "Called onRestart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(CURRENT_ACTIVITY, "Called onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(CURRENT_ACTIVITY, "Called onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(CURRENT_ACTIVITY, "Called onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(CURRENT_ACTIVITY, "Called onDestroy")
    }


}