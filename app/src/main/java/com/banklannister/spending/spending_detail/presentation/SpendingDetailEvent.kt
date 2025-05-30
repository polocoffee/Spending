package com.banklannister.spending.spending_detail.presentation

sealed interface SpendingDetailEvent {

    data object SaveSuccess: SpendingDetailEvent
    data object SaveFailed: SpendingDetailEvent

}