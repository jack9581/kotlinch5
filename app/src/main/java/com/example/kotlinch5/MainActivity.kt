package com.example.kotlinch5

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("請選擇功能")
                .setMessage("請依據下方按鈕選擇顯示的物件")
                .setNeutralButton("取消", DialogInterface.OnClickListener { dialog, which ->
                    Toast.makeText(this, "Dialog關閉", Toast.LENGTH_LONG).show()
                })
                .setNegativeButton("自訂義Toast", DialogInterface.OnClickListener { dialog, which ->
                    showToast()
                })
                .setPositiveButton("顯示List", DialogInterface.OnClickListener { dialog, which ->
                    showlistdialog()
                })
                .show()
        }
    }
    private fun showToast()
    {
        val toast =Toast(this)
        toast.view=layoutInflater.inflate(R.layout.custom_toast,null)
        toast.duration=Toast.LENGTH_LONG
        toast.setGravity(Gravity.CENTER,0,0)
        toast.show()
    }
    private fun showlistdialog()
    {
        val list= arrayOf("message1","message2","message3","message4","message5")
        AlertDialog.Builder(this)
            .setTitle("使用LIST呈現")
            .setItems(list,DialogInterface.OnClickListener { dialog, which ->
                Toast.makeText(this, "你選的是"+list[which], Toast.LENGTH_LONG).show()
            })
            .show()
    }
}