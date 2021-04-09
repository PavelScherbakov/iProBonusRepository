package ru.pscher.android.iprobonusrepository.network.result.dto

import com.squareup.moshi.FromJson
import com.squareup.moshi.JsonClass
import com.squareup.moshi.ToJson

@JsonClass(generateAdapter = true)
data class ResultOperationDto(
    val status: StatusResultEnum,
    val message: String?,
    val messageDev: String?,
    val codeResult: Int,
    val duration: Double,
    val idLog: String
)

enum class StatusResultEnum(val value: Int) {
    STATUS_0(0),
    STATUS_1(1),
    STATUS_2(2);

    companion object {
        private val map = StatusResultEnum.values().associateBy(StatusResultEnum::value);
        fun fromInt(value: Int) = map[value]
    }
}

class StatusResultEnumAdapter {
    @ToJson
    fun toJson(enum: StatusResultEnum): Int {
        return enum.value
    }

    @FromJson
    fun fromJson(value: Int): StatusResultEnum? {
        return StatusResultEnum.fromInt(value)
    }
}