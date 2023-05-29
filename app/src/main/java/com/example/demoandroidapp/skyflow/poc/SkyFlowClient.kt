package com.example.demoandroidapp.skyflow.poc

import Skyflow.Client
import Skyflow.Env
import Skyflow.LogLevel
import Skyflow.init

private fun getConfiguration(): Skyflow.Configuration {
    return Skyflow.Configuration(
        vaultID = "vaultUrlabc13487dhg56svbcgf7",
        vaultURL = "https://vault.url.com",
        tokenProvider = POCTokenProvider(),
        options = Skyflow.Options(
            logLevel = LogLevel.ERROR,
            env = Env.PROD
        )
    )
}

fun getSkyFlowClient(): Client {
    val config = getConfiguration()
    return init(config)
    // changes here as well
}
