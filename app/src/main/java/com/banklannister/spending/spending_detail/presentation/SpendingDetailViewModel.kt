package com.banklannister.spending.spending_detail.presentation


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.banklannister.spending.core.domain.Spending
import com.banklannister.spending.spending_detail.domain.UpsertSpendingUseCase
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import java.time.ZonedDateTime


class SpendingDetailViewModel(
    private val upsertSpendingUseCase: UpsertSpendingUseCase
) : ViewModel() {

    var state by mutableStateOf(SpendingDetailState())
        private set

    private val _eventChannel = Channel<SpendingDetailEvent>()
    val event = _eventChannel.receiveAsFlow()

    fun onAction(action: SpendingDetailAction) {
        when (action) {
            is SpendingDetailAction.UpdateKilograms -> {
                state = state.copy(
                    kilograms = action.newKilograms
                )
            }

            is SpendingDetailAction.UpdateName -> {
                state = state.copy(
                    name = action.newName
                )
            }

            is SpendingDetailAction.UpdatePrice -> {
                state = state.copy(
                    price = action.newPrice
                )
            }

            is SpendingDetailAction.UpdateQuantity -> {
                state = state.copy(
                    quantity = action.newQuantity
                )
            }

            SpendingDetailAction.SaveSpending -> {
                viewModelScope.launch {
                    if (saveSpending()) {
                        _eventChannel.send(SpendingDetailEvent.SaveSuccess)
                    } else {
                        _eventChannel.send(SpendingDetailEvent.SaveFailed)
                    }
                }
            }
        }
    }

    private suspend fun saveSpending(): Boolean {
        val spending = Spending(
            spendingId = null,
            name = state.name,
            price = state.price,
            kilograms = state.kilograms,
            quantity = state.quantity,
            dateTimeUtc = ZonedDateTime.now()
        )

        return upsertSpendingUseCase(spending)
    }

}