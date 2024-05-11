package com.example.appleadtech

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import androidx.lifecycle.lifecycleScope
import com.example.appleadtech.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var editText = binding.editTextName
        var button = binding.button
        var textView = binding.textName


        button.setOnClickListener {
            val input  = editText.text.toString().replace("-", "")
            validateCode(input)

        }

    }
    private fun validateCode(input: String) {
        lifecycleScope.launch()

            val isValid = CodeValidation.isValid(input)
            }
            binding.textName.text = if (isValid) "Codice Valido" else "Codice Non Valido"
        }
    }
}
