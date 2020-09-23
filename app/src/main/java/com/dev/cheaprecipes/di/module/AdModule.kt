package com.dev.cheaprecipes.di.module

import android.content.Context
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.InterstitialAd
import dagger.Module
import dagger.Provides
import dagger.hilt.migration.DisableInstallInCheck

@Module
@DisableInstallInCheck
class AdModule {

    @Provides
    fun provideInterstitialAd(context: Context) : InterstitialAd {
        return InterstitialAd(context).apply {
            adUnitId = "ca-app-pub-6875098488739325/7985816592"
            loadAd(AdRequest.Builder().build())
        }
    }
}