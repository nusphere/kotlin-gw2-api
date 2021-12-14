package guildwars2

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import guildwars2.api.auth.account.AccountExtension
import guildwars2.api.auth.dyes.DyesExtension
import guildwars2.api.auth.finisher.FinisherExtension
import guildwars2.api.auth.tokeninfo.TokenInfoExtension
import guildwars2.api.misc.build.BuildExtension
import guildwars2.api.misc.color.ColorExtension
import guildwars2.api.misc.quaggan.QuagganExtension
import guildwars2.api.misc.title.TitleExtension
import guildwars2.api.misc.world.WorldExtension
import guildwars2.api.wvw.ability.AbilityExtension
import guildwars2.api.wvw.match.MatchExtension
import guildwars2.api.wvw.objective.ObjectiveExtension
import guildwars2.api.wvw.rank.RankExtension
import guildwars2.api.wvw.upgrade.UpgradeExtension
import guildwars2.api.wvw.wvw.WvWExtension
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Api (private var apiKey: String)
{
    private val client = OkHttpClient.Builder().addInterceptor { chain ->
        val newRequest = chain.request().newBuilder()
            .addHeader("Authorization", "Bearer $apiKey")
            .build()
        chain.proceed(newRequest)
    }.build()

    private val retrofit: Retrofit
        get() = Retrofit
        .Builder()
        .client(client)
        .baseUrl("https://api.guildwars2.com/")
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    inner class Auth(
        override val retrofit: Retrofit = this.retrofit,
    ): AccountExtension, TokenInfoExtension, DyesExtension, FinisherExtension

    inner class Misc(
        override val retrofit: Retrofit = this.retrofit,
    ): WorldExtension, BuildExtension, TitleExtension, ColorExtension, QuagganExtension

    inner class WvW(
        override val retrofit: Retrofit = this.retrofit,
    ): WvWExtension, MatchExtension, AbilityExtension, UpgradeExtension, RankExtension, ObjectiveExtension
}