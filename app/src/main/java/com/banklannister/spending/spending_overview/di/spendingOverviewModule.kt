package com.banklannister.spending.spending_overview.di



import com.banklannister.spending.spending_overview.presentation.SpendingOverviewViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val spendingOverviewModule = module {
    viewModel { SpendingOverviewViewModel(get(), get()) }
}