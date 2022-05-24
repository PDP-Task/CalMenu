package com.example.calmenu

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.widget.AppCompatImageButton
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import com.example.calmenu.databinding.ActivityMainBinding
import com.example.calmenu.util.MockData
import com.example.calmenu.util.MockData.proLanguages

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViews()

    }

    private fun initViews() {
        binding.btnAdd.setOnClickListener {
            val number1 = binding.editOne.text.toString().trim()
            val number2 = binding.editTwo.text.toString().trim()

            if (isNotEmpty(number1, number2)) {
                val sum = add(number1.toInt(), number2.toInt())
                binding.textResult.text = sum
            } else {
                toast("Enter data")
            }
        }
    }

    private fun add(a: Int, b: Int): String {
        return (a + b).toString()
    }

    private fun isNotEmpty(s1: String, s2: String): Boolean {
        return !(TextUtils.isEmpty(s1) && TextUtils.isEmpty(s2))
    }
    private fun toast(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }
}
