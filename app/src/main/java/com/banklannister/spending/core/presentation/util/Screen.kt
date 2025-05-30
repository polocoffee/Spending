package com.banklannister.spending.core.presentation.util


sealed interface Screen {

    @kotlinx.serialization.Serializable
    data object SpendingOverview: Screen

    @kotlinx.serialization.Serializable
    data class SpendingDetail(val spendingId: Int = -1): Screen

    @kotlinx.serialization.Serializable
    data object Balance: Screen

}