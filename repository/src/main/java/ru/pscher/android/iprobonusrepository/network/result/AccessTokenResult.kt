package ru.pscher.android.iprobonusrepository.network.result

import com.squareup.moshi.Json
import ru.pscher.android.iprobonusrepository.network.result.dto.ResultOperationDto

data class AccessTokenResult (
        @Json(name = "result")
        override val resultOperation: ResultOperationDto,
        val accessToken: String?
    ): BasicResult