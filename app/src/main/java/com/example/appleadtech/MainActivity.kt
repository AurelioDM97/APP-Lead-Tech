package com.example.appleadtech

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import com.example.appleadtech.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var editText = binding.editTextName
        var button = binding.button
        var textView = binding.textName


        binding.button.setOnClickListener {
            var str = editText.text.toString()
            textView.text = str
        }

    }





}