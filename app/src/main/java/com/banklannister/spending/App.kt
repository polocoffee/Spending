package com.banklannister.spending

import android.app.Application
import com.banklannister.spending.balance.di.balanceModule
import com.banklannister.spending.core.di.coreModule
import com.banklannister.spending.spending_detail.di.spendingDetailModule
import com.banklannister.spending.spending_overview.di.spendingOverviewModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(
                coreModule,
                balanceModule,
                spendingOverviewModule,
                spendingDetailModule
            )
        }

    }

}