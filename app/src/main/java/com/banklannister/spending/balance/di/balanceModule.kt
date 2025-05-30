package com.banklannister.spending.balance.di

import com.banklannister.spending.balance.presentation.BalanceViewModel
import org.koin.dsl.module
import org.koin.androidx.viewmodel.dsl.viewModel


val balanceModule = module {
    viewModel { BalanceViewModel(get()) }
}