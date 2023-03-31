package com.example.demoandroidapp.skyflow.poc

import Skyflow.Callback
import okhttp3.OkHttpClient
import okio.IOException
import org.json.JSONObject

class POCTokenProvider : Skyflow.TokenProvider {
    override fun getBearerToken(callback: Callback) {
        val url = "token url"
        val request = okhttp3.Request.Builder().url(url).build()
        val okHttpClient = OkHttpClient()
        try {
            val thread = Thread {
                run {
                    okHttpClient.newCall(request).execute().use { response ->
                        if (!response.isSuccessful)
                            throw IOException("Unexpected code $response")
                        val accessTokenObject = JSONObject(
                            response.body!!.string().toString()
                        )
                        val accessToken = accessTokenObject["accessToken"]
                        callback.onSuccess("$accessToken")
                    }
                }
            }
            thread.start()
        } catch (exception: Exception) {
            callback.onFailure(exception)
        }
    }
}