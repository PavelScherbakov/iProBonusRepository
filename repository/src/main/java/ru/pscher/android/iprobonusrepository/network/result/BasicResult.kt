package ru.pscher.android.iprobonusrepository.network.result

import ru.pscher.android.iprobonusrepository.network.result.dto.ResultOperationDto

interface BasicResult {
    val resultOperation: ResultOperationDto

    companion object {
        val RESULT_OK = 0
        val ERROR_TOKEN_EXPIRED = 1
    }
}