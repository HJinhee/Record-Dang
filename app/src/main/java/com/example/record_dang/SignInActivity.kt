package com.example.record_dang

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.record_dang.databinding.ActivitySignInBinding
import com.example.record_dang.presentation.home.HomeFragment
import com.example.record_dang.R


class SignInActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignInBinding
    private val mainActivityLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            //데이터를 받아서 할 일이 들어가는 칸

        }

    private val signUpActivityLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            //데이터를 받아서 할 일이 들어가는 칸
            if (it.resultCode == Activity.RESULT_OK) {
                if (intent != null) {
                    binding.etLoginId.setText(it.data?.extras?.getString("userId"))
                    binding.etLoginPw.setText(it.data?.extras?.getString("userPw"))
                }
            }

        }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.d(CURRENT_ACTIVITY, "Called onCreate")

        loginButtonClickEvent()
        signUpClickEvent()


    }

    private fun loginButtonClickEvent() {
        binding.btnLogin.setOnClickListener {

            val userId = binding.etLoginId.text
            val userPw = binding.etLoginPw.text
            if (userId.isNullOrBlank() || userPw.isNullOrBlank()) {
                Toast.makeText(this@SignInActivity, "아이디/비밀번호를 확인해주세요!", Toast.LENGTH_SHORT)
                    .show()
            } else {
//                val transaction = supportFragmentManager.beginTransaction()
//                val homeFragment = HomeFragment()
//                transaction.replace(R.id.nav_host_main, homeFragment)
//                transaction.addToBackStack(null)
//                transaction.commit()

                val intent = Intent(this@SignInActivity, MainActivity::class.java)
                mainActivityLauncher.launch(intent)

//                transaction.add(R.id.signin_layout, homeFragment)
//                transaction.commit()

            }
        }
    }


//    private fun startHomeFragment(){
//        //HomeActivity로 이동
//        val intent = Intent(this@SignInActivity, HomeFragment::class.java)
//        startActivity(intent)
//    }


    private fun signUpClickEvent() {
        binding.tvSignUp.setOnClickListener {

            val intent = Intent(this@SignInActivity, SignUpActivity::class.java)
            signUpActivityLauncher.launch(intent)

        }
    }


    companion object {
        const val CURRENT_ACTIVITY = "SignInActivity"
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
