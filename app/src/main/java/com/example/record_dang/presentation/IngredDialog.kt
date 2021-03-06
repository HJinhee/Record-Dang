package com.example.record_dang.presentation

import android.app.Dialog
import android.content.Context
import android.view.Window
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.record_dang.R

class IngredDialog(context : Context) {

    private val dlg = Dialog(context)   //부모 액티비티의 context 가 들어감
    private lateinit var editIngred : EditText
    private lateinit var textUserIngred : TextView
    private lateinit var btnOK : Button
    private lateinit var btnCancel : Button
    private lateinit var listener : MyDialogOKClickedListener

    fun start(content : String) {
        dlg.requestWindowFeature(Window.FEATURE_NO_TITLE)   //타이틀바 제거
        dlg.setContentView(R.layout.dialog_ingred)     //다이얼로그에 사용할 xml 파일을 불러옴
        dlg.setCancelable(false)    //다이얼로그의 바깥 화면을 눌렀을 때 다이얼로그가 닫히지 않도록 함

        editIngred = dlg.findViewById(R.id.et_user_ingred)
        textUserIngred = dlg.findViewById(R.id.text_user_ingred)
        textUserIngred.text = textUserIngred.text.toString() + content

        btnOK = dlg.findViewById(R.id.ok)
        btnOK.setOnClickListener {

            listener.onOKClicked("확인을 눌렀습니다")
            dlg.dismiss()
        }



        btnCancel = dlg.findViewById(R.id.cancel)
        btnCancel.setOnClickListener {
            dlg.dismiss()
        }

        dlg.show()
    }


    fun setOnOKClickedListener(listener: (String) -> Unit) {
        this.listener = object: MyDialogOKClickedListener {
            override fun onOKClicked(content: String) {
                listener(content)
            }
        }
    }


    interface MyDialogOKClickedListener {
        fun onOKClicked(content : String)
    }
}
