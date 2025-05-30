package com.banklannister.spending.spending_detail.presentation


sealed interface SpendingDetailAction {

    data class UpdateName(val newName: String): SpendingDetailAction
    data class UpdatePrice(val newPrice: Double): SpendingDetailAction
    data class UpdateKilograms(val newKilograms: Double): SpendingDetailAction
    data class UpdateQuantity(val newQuantity: Double): SpendingDetailAction

    data object SaveSpending: SpendingDetailAction

}