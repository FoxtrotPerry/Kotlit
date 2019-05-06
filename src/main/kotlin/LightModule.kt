package com.perry

import com.perry.services.ApiService

class LightModule {

    init {
        beginFetching()
    }

    private fun beginFetching() {
        while(true) {
            ApiService.loadAndPrintRGB()
            Thread.sleep(2500)
        }
    }
}