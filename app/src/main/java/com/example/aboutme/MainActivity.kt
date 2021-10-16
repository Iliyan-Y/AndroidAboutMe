package com.example.aboutme

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

  private lateinit var binding: ActivityMainBinding

  private val myName: MyName = MyName("Kiro Skalata")

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
    binding.myName = myName
    //setContentView(R.layout.activity_main)
//    val doneButton = findViewById<Button>(R.id.done_button)
//    doneButton.setOnClickListener {
//      swapText()
//      doneButton.isEnabled = false
//    }
    binding.doneButton.setOnClickListener {
      swapText(it)
    }
  }

  private fun swapText(view: View) {
    //without binding
//    val nickNameEdit = findViewById<TextView>(R.id.nickname_edit)
//    val nickNameDisplay = findViewById<TextView>(R.id.nick_name)
//    nickNameDisplay.text = nickNameEdit.text
//    nickNameEdit.visibility = View.GONE
//    nickNameDisplay.visibility = View.VISIBLE

    binding.apply {
      //nickName.text = nicknameEdit.text
      myName?.nickName = nicknameEdit.text.toString()
      invalidateAll()
      nicknameEdit.visibility = View.GONE
      nickName.visibility = View.VISIBLE
      doneButton.isEnabled = false

    }

    //hide keyboard
    val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
    imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0)
  }

}