package com.banklannister.spending.core.data


import com.banklannister.spending.core.data.local.SpendingEntity
import com.banklannister.spending.core.domain.Spending
import java.time.Instant
import java.time.ZoneId


fun SpendingEntity.toSpending(): Spending = Spending(
    spendingId = spendingId ?: 0,
    name = name,
    price = price,
    kilograms = kilograms,
    quantity = quantity,
    dateTimeUtc = Instant.parse(dateTimeUtc).atZone(ZoneId.of("UTC"))
)

fun Spending.toNewSpendingEntity(): SpendingEntity = SpendingEntity(
    name = name,
    price = price,
    kilograms = kilograms,
    quantity = quantity,
    dateTimeUtc = dateTimeUtc.toInstant().toString()
)

fun Spending.toEditedSpendingEntity(): SpendingEntity = SpendingEntity(
    spendingId = spendingId,
    name = name,
    price = price,
    kilograms = kilograms,
    quantity = quantity,
    dateTimeUtc = dateTimeUtc.toInstant().toString()
)