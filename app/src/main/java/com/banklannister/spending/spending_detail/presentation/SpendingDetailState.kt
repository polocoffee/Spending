package com.banklannister.spending.spending_detail.presentation

data class SpendingDetailState(
    val name: String = "",
    val price: Double = 0.0,
    val kilograms: Double = 0.0,
    val quantity: Double = 0.0,
)