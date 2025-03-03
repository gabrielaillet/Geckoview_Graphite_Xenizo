package com.example.myapplication

import android.app.Activity
import android.os.Bundle
import org.mozilla.geckoview.GeckoRuntime
import org.mozilla.geckoview.GeckoRuntimeSettings
import org.mozilla.geckoview.GeckoSession
import org.mozilla.geckoview.GeckoView

class BrowserActivity : Activity() {
    private lateinit var geckoView: GeckoView
    private lateinit var geckoSession: GeckoSession
    private lateinit var geckoRuntime: GeckoRuntime

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_browser)

        geckoView = findViewById(R.id.geckoView)

        // Create GeckoRuntimeSettings with web fonts enabled
        val settings = GeckoRuntimeSettings.Builder()
            .build()

        // Initialize GeckoRuntime with the custom settings
        geckoRuntime = GeckoRuntime.create(this, settings)

        geckoSession = GeckoSession()
        geckoSession.open(geckoRuntime)


        geckoView.setSession(geckoSession)

        // Load the React app's main HTML file from assets
        geckoSession.loadUri("resource://android/assets/build/index.html")
    }
}
