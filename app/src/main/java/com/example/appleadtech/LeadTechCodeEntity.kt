package com.example.appleadtech

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "lead_tech_codes")
data class LeadTechCodeEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val code: String?,
    val isValid: Boolean?
)
