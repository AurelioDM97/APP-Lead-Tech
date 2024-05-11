package com.example.appleadtech

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface LeadTechCodeDao {
    @Insert
    fun insert(code: LeadTechCodeEntity)

    @Query("SELECT * FROM lead_tech_codes")
    fun getAll(): List<LeadTechCodeEntity>
}