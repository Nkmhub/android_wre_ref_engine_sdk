package com.example.wre_ref_engine_sdk.Services.Affiliate.Adjust

import android.content.Context
import com.adjust.sdk.Adjust
import com.adjust.sdk.AdjustConfig
import com.adjust.sdk.LogLevel
import com.example.wre_ref_engine_sdk.Models.AdjustEnv
import com.example.wre_ref_engine_sdk.Services.Affiliate.AffiliateService

class AdjustAffiliateService : AffiliateService {

    override fun processReferral(
        context: Context,
        deepLink: String,
        environment: AdjustEnv,
        appToken: String
    ) {
        println("Handling Adjust referral")
        println("Environment: $environment")
        println("App Token: $appToken")
        println("Deep Link: $deepLink")

        val adjustEnvironment = when (environment) {
            AdjustEnv.production -> AdjustConfig.ENVIRONMENT_PRODUCTION
            AdjustEnv.sandbox -> AdjustConfig.ENVIRONMENT_SANDBOX
        }

        val config = AdjustConfig(context, appToken, adjustEnvironment)
        config.setLogLevel(LogLevel.VERBOSE)
        Adjust.initSdk(config)
    }
}
