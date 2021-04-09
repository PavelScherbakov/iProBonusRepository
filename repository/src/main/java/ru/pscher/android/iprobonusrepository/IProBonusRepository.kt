package ru.pscher.android.iprobonusrepository

import android.app.Application
import com.jakewharton.threetenabp.AndroidThreeTen
import ru.pscher.android.iprobonusrepository.network.IProBonusApi

object IProBonusRepository {
    lateinit var config: IProBonusRepositoryConfig
    lateinit var app: Application

    fun init(app: Application, config: IProBonusRepositoryConfig) {
        this.app = app
        this.config = config

        AndroidThreeTen.init(app)

        IProBonusApi.init()
    }
}

data class IProBonusRepositoryConfig (
    val baseUrl: String,
    val accessKey: String,
    val clientId: String,
    val deviceId: String)

