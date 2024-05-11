package com.example.appleadtech

object CodeValidation {
    fun isValid(code: String): Boolean {
        if (code.length != 10) return false

        var add = 0
        for (i in 0 until 9) {
            val digit = code[i].toString().toIntOrNull() ?: return false
            add += digit * (10 - i)
        }

      return false
        }
}
