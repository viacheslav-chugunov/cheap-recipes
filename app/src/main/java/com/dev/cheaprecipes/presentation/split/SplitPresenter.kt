package com.dev.cheaprecipes.presentation.split

import android.content.Context
import com.dev.cheaprecipes.presentation.split.SplitView
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.InterstitialAd
import com.google.android.gms.ads.MobileAds
import moxy.MvpPresenter

class SplitPresenter(private val context: Context) : MvpPresenter<SplitView>() {
    private lateinit var interstitialAd: InterstitialAd

    fun initInterstitialAd() {
        MobileAds.initialize(context) {}
        interstitialAd = InterstitialAd(context)
        interstitialAd.adUnitId = "ca-app-pub-6875098488739325/7985816592"
        interstitialAd.loadAd(AdRequest.Builder().build())
        interstitialAd.adListener = object : AdListener() {
            override fun onAdClosed() {
                interstitialAd.loadAd(AdRequest.Builder().build())
                viewState.startNextActivity()
            }
        }
    }

    fun startNewActivityWithAdIfLoaded() {
        if (interstitialAd.isLoaded)
            interstitialAd.show()
        else
            viewState.startNextActivity()
    }
}
