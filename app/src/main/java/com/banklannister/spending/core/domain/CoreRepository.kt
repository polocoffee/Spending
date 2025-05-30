package com.banklannister.spending.core.domain

interface CoreRepository {
    suspend fun updateBalance(balance: Double)
    suspend fun getBalance(): Double
}