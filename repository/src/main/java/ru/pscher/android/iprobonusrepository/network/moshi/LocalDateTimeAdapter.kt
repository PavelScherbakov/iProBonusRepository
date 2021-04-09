package ru.pscher.android.iprobonusrepository.network.moshi

import com.squareup.moshi.FromJson
import com.squareup.moshi.JsonDataException
import com.squareup.moshi.ToJson
import org.threeten.bp.LocalDate
import org.threeten.bp.LocalDateTime
import org.threeten.bp.format.DateTimeFormatter


class LocalDateTimeAdapter {
    @ToJson
    fun toJson(value: LocalDateTime): String? {
        return value.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)
    }

    @FromJson
    fun fromJson(value: String): LocalDateTime? {
        try {
            val formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME
            return LocalDateTime.parse(value, formatter)
        } catch (e: Exception) {
            try {
                val formatter = DateTimeFormatter.ISO_LOCAL_DATE
                return LocalDate.parse(value, formatter).atTime(0, 0, 0, 0)
            } catch (e: Exception) {
                throw JsonDataException(e)
            }
        }
    }
}