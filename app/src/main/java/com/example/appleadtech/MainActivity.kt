package com.example.appleadtech

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import com.example.appleadtech.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var database: AppDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        database = AppDatabase.getDatabase(this)


        var editText = binding.editTextName
        var button = binding.button
        var textView = binding.textName

        //aggiungo un listener al pulsante, utilizzo replace per togliere eventuali trattini
        button.setOnClickListener {
            val input = editText.text.toString().replace("-", "")
            validateCode(input)
        }
    }
    private fun validateCode(input: String) {
        lifecycleScope.launch {
            try {
                val isValid = withContext(Dispatchers.Default) {
                    CodeValidation.isValid(input)
                }
                updateCoroutine(isValid)
                saveCodeToDatabase(isValid, input)

            } catch (e: Exception) {
                // errore
                e.printStackTrace()
            }
        }
    }
    private fun updateCoroutine(isValid: Boolean) {
        binding.textName.text = if (isValid) "Codice Valido" else "Codice Non Valido"
    } //aggiorno l'interfaccia utente separatamente


    //utlizzo lifecycle per eseguire una coroutine nel salvataggio dei dati per non bloccare il thread principale
    private fun saveCodeToDatabase(isValid: Boolean, code: String) {
        lifecycleScope.launch {
            withContext(Dispatchers.IO) {
                database.leadTechCodeDao()
                    .insert(LeadTechCodeEntity(code = code, isValid = isValid))
            }
        }
    }
}

