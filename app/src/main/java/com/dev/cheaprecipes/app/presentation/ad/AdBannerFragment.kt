package com.dev.cheaprecipes.app.presentation.ad

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dev.cheaprecipes.R
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import kotlinx.android.synthetic.main.fragment_ad_banner.*


class AdBannerFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_ad_banner, container, false);
        val adBanner = view.findViewById<AdView>(R.id.ad_banner)
        MobileAds.initialize(context) {}
        val adRequest = AdRequest.Builder().build()
        adBanner.loadAd(adRequest)
        return view
    }
}