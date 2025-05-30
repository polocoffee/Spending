package com.banklannister.spending.spending_overview.presentation


import com.banklannister.spending.core.domain.Spending
import java.time.ZonedDateTime

data class SpendingOverviewState(
    val spendingList: List<Spending> = emptyList(),
    val dateList: List<ZonedDateTime> = emptyList(),
    val balance: Double = 0.0,
    val pickedDate: ZonedDateTime = ZonedDateTime.now(),
    val isDropDownMenuVisible: Boolean = false,
)