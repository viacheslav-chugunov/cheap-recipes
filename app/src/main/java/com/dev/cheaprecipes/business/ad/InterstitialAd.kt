package com.dev.cheaprecipes.business.ad

import android.content.Context
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.MobileAds

class InterstitialAd(private val context: Context,
                     private val setOnAdClosed: () -> Unit,
                     private val setOnAdFailedToLoad: () -> Unit) {

    fun run() {
        val ad = setupInterstitialAd()
        ad.adListener = object : AdListener() {
            override fun onAdLoaded() = ad.show()
            override fun onAdClosed() = setOnAdClosed()
            override fun onAdFailedToLoad(p0: LoadAdError?) = setOnAdFailedToLoad()
        }
    }

    private fun setupInterstitialAd() : com.google.android.gms.ads.InterstitialAd {
        MobileAds.initialize(context) {}
        val ad = com.google.android.gms.ads.InterstitialAd(context)
        ad.adUnitId = "ca-app-pub-6875098488739325/7985816592"
        ad.loadAd(AdRequest.Builder().build())
        return ad
    }
}