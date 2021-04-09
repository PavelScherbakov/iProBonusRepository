package ru.pscher.android.iprobonusrepository.network.result

import ru.pscher.android.iprobonusrepository.network.result.dto.DataInfoByAvailableBonusesDto
import ru.pscher.android.iprobonusrepository.network.result.dto.ResultOperationDto

data class DataInfoByAvailableBonusesResult(
    override val resultOperation: ResultOperationDto,
    val data: DataInfoByAvailableBonusesDto?
    ) : BasicResult
