package ru.pscher.android.iprobonusrepository.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.*
import ru.pscher.android.iprobonusrepository.BuildConfig
import ru.pscher.android.iprobonusrepository.IProBonusRepository
import ru.pscher.android.iprobonusrepository.network.moshi.LocalDateTimeAdapter
import ru.pscher.android.iprobonusrepository.network.requests.AccessTokenRequest
import ru.pscher.android.iprobonusrepository.network.result.AccessTokenResult
import ru.pscher.android.iprobonusrepository.network.result.DataInfoByAvailableBonusesResult
import ru.pscher.android.iprobonusrepository.network.result.dto.StatusResultEnumAdapter

interface IProBonusApiService {
    /**
     * Создает и возвращает токен доступа клиента
     */
    @POST("/api/v3/clients/accesstoken")
    suspend fun postAccessToken(@Body request: AccessTokenRequest): AccessTokenResult


    /**
     * Общая информацию о бонусах клиента
     */
    @GET(" /api/v3/ibonus/generalinfo/{AccessToken}")
    suspend fun getGeneralInfo(@Path("AccessToken") accessToken: String): DataInfoByAvailableBonusesResult

}

object IProBonusApi {
    /*val retrofitService : IProBonusApiService by lazy {
        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .add(StatusResultEnumAdapter())
            .add(LocalDateTimeAdapter())
            .build()

        val okHttpClient = OkHttpClient.Builder().apply {
            addInterceptor(
                Interceptor { chain ->
                    val builder = chain.request().newBuilder()
                    builder.header("AccessKey", IProBonusRepository.config.accessKey)
                    return@Interceptor chain.proceed(builder.build())
                }
            )
        }.build()

        val retrofit = Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .baseUrl(IProBonusRepository.config.baseUrl)
            .client(okHttpClient)
            .build()

        retrofit.create(IProBonusApiService::class.java)
    }*/

    lateinit var retrofitService : IProBonusApiService

    fun init() {
        val moshi = Moshi.Builder()
                .add(KotlinJsonAdapterFactory())
                .add(StatusResultEnumAdapter())
                .add(LocalDateTimeAdapter())
                .build()

        val okHttpClient = OkHttpClient.Builder().apply {
            addInterceptor(
                Interceptor { chain ->
                    val builder = chain.request().newBuilder()
                    builder.header("AccessKey", IProBonusRepository.config.accessKey)
                    return@Interceptor chain.proceed(builder.build())
                }
            )
        }.let {
            if (BuildConfig.DEBUG) {
                val logging = HttpLoggingInterceptor()
                logging.level = (HttpLoggingInterceptor.Level.BODY)
                it.addInterceptor(logging)
            }
            return@let it
        }.build()

        val retrofit = Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .baseUrl(IProBonusRepository.config.baseUrl)
            .client(okHttpClient)
            .build()

        retrofitService = retrofit.create(IProBonusApiService::class.java)
    }

}



