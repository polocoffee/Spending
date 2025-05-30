package com.banklannister.spending.spending_detail.di


import com.banklannister.spending.spending_detail.domain.UpsertSpendingUseCase
import com.banklannister.spending.spending_detail.presentation.SpendingDetailViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val spendingDetailModule = module {
    single { UpsertSpendingUseCase(get()) }
    viewModel { SpendingDetailViewModel(get()) }
}