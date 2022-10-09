package com.example.waterfitbit

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface WaterDao {
    @Query("SELECT * FROM water_consumption ORDER BY days")
    fun getAll(): Flow<List<WaterConsumption>>

    @Insert
    fun insert(water: WaterConsumption)

    @Query("DELETE FROM water_consumption")
    fun deleteAll()

}