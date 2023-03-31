package com.example.demoandroidapp.skyflow.poc

import Skyflow.Client
import Skyflow.Env
import Skyflow.LogLevel
import Skyflow.init

private fun getConfiguration(): Skyflow.Configuration {
    return Skyflow.Configuration(
        vaultID = "VAULT_ID",
        vaultURL = "VAULT_URL",
        tokenProvider = POCTokenProvider(),
        options = Skyflow.Options(
            logLevel = LogLevel.DEBUG,
            env = Env.DEV
        )
    )
}

fun getSkyFlowClient(): Client {
    val config = getConfiguration()
    return init(config)
}
