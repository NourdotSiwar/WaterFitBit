package com.example.waterfitbit

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "water_consumption")

data class WaterConsumption(
    @ColumnInfo(name = "Days") val days: String?,
    @ColumnInfo(name = "Cups") val cups: String?,
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
) {
}