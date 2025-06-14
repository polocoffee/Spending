package com.banklannister.spending.core.data.local

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert

@Dao
interface SpendingDao {

    @Upsert
    suspend fun upsertSpending(entity: SpendingEntity)

    @Query("SELECT * FROM spendingentity")
    suspend fun getAllSpending(): List<SpendingEntity>

    @Query("SELECT * FROM spendingentity WHERE spendingId = :id")
    suspend fun getSpending(id: Int): SpendingEntity

    @Query("SELECT dateTimeUtc FROM spendingentity")
    suspend fun getAllDates(): List<String>

    @Query("SELECT SUM(price) FROM spendingentity")
    suspend fun getSpendBalance(): Double?

    @Query("DELETE FROM spendingentity WHERE spendingId = :id")
    suspend fun deleteSpending(id: Int)

}