package ru.pscher.android.iprobonusrepository.repository

import ru.pscher.android.iprobonusrepository.IProBonusRepository
import ru.pscher.android.iprobonusrepository.network.IProBonusApi
import ru.pscher.android.iprobonusrepository.network.requests.AccessTokenRequest
import ru.pscher.android.iprobonusrepository.network.result.AccessTokenResult

class AccessTokenRepository {
    suspend fun getAccessToken(): AccessTokenResult {

        return IProBonusApi.retrofitService.postAccessToken(
                AccessTokenRequest(
                    IProBonusRepository.config.clientId,
                    "",
                    "device",
                    IProBonusRepository.config.deviceId))
    }
}