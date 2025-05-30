package com.banklannister.spending.core.di


import android.content.Context
import androidx.room.Room
import com.banklannister.spending.core.data.RoomSpendingDataSource
import com.banklannister.spending.core.data.local.CoreRepositoryImpl
import com.banklannister.spending.core.data.local.SpendingDatabase
import com.banklannister.spending.core.domain.CoreRepository
import com.banklannister.spending.core.domain.LocalSpendingDataSource
import org.koin.android.ext.koin.androidApplication
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module


val coreModule = module {
    single {
        Room.databaseBuilder(
            androidApplication(),
            SpendingDatabase::class.java,
            "spending_database_db"
        ).build()
    }

    single { get<SpendingDatabase>().dao }

    single {
        androidApplication().getSharedPreferences(
            "spending_tracker_preferences", Context.MODE_PRIVATE
        )
    }

    singleOf(::RoomSpendingDataSource).bind<LocalSpendingDataSource>()
    singleOf(::CoreRepositoryImpl).bind<CoreRepository>()
}