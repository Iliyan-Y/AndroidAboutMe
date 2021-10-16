package com.example.aboutme

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    val doneButton = findViewById<Button>(R.id.done_button)
    doneButton.setOnClickListener {
      swapText()
      doneButton.isEnabled = false
    }
  }

  private fun swapText() {
    val nickNameEdit = findViewById<TextView>(R.id.nickname_edit)
    val nickNameDisplay = findViewById<TextView>(R.id.nick_name)

    nickNameDisplay.text = nickNameEdit.text

    nickNameEdit.visibility = View.GONE
    nickNameDisplay.visibility = View.VISIBLE
    //hide keyboard
    val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
    imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0)
  }

}