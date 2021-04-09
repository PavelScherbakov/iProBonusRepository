package ru.pscher.android.iprobonusrepository.network.requests

data class AccessTokenRequest (
    val idClient: String,
    val accessToken: String = "",
    val paramName: String,
    val paramValue: String,
    val latitude: Float = 0f,
    val longitude: Float = 0f,
    val sourceQuery: Int = 0
    )