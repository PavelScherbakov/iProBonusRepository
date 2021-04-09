package ru.pscher.android.iprobonusrepository.network.result.dto

import org.threeten.bp.LocalDateTime


data class DataInfoByAvailableBonusesDto(
    val typeBonusName: String?,
    val currentQuantity: Double,
    val forBurningQuantity: Double,
    val dateBurning: LocalDateTime
    )
