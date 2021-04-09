package ru.pscher.android.iprobonusrepository.repository

import ru.pscher.android.iprobonusrepository.network.IProBonusApi
import ru.pscher.android.iprobonusrepository.network.result.DataInfoByAvailableBonusesResult

class BonusRepository {
    suspend fun getDataInfoByAvailableBonuses(accessToken: String): DataInfoByAvailableBonusesResult {
        return IProBonusApi.retrofitService.getGeneralInfo(accessToken)
    }
}