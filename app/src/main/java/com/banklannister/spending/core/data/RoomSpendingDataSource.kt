package com.banklannister.spending.core.data

import com.banklannister.spending.core.data.local.SpendingDao
import com.banklannister.spending.core.domain.LocalSpendingDataSource
import com.banklannister.spending.core.domain.Spending
import java.time.Instant
import java.time.LocalDate
import java.time.ZoneId
import java.time.ZonedDateTime


class RoomSpendingDataSource(
    private val dao: SpendingDao
) : LocalSpendingDataSource {

    override suspend fun getAllSpending(): List<Spending> {
        return dao.getAllSpending().map { it.toSpending() }
    }

    override suspend fun getSpendingByDate(
        dateTimeUtc: ZonedDateTime
    ): List<Spending> {
        return dao.getAllSpending().map { it.toSpending() }
            .filter { spending ->
                spending.dateTimeUtc.dayOfMonth == dateTimeUtc.dayOfMonth
                        && spending.dateTimeUtc.month == dateTimeUtc.month
                        && spending.dateTimeUtc.year == dateTimeUtc.year
            }
    }

    override suspend fun getAllDates(): List<ZonedDateTime> {
        val uniqueDates = mutableSetOf<LocalDate>()
        return dao.getAllDates()
            .map { Instant.parse(it).atZone(ZoneId.of("UTC")) }
            .filter {
                uniqueDates.add(it.toLocalDate())
            }
    }

    override suspend fun getSpending(id: Int): Spending {
        return dao.getSpending(id).toSpending()
    }

    override suspend fun upsertSpending(spending: Spending) {
        dao.upsertSpending(
            spending.toNewSpendingEntity()
        )
    }

    override suspend fun getSpendBalance(): Double {
        return dao.getSpendBalance() ?: 0.0
    }

    override suspend fun deleteSpending(id: Int) {
        dao.deleteSpending(id)
    }
}
