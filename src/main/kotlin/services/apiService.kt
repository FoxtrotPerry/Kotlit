package com.perry.services

import com.perry.SolarData
import java.time.LocalDateTime

class ApiService {
    companion object {
        fun getSolarData(): SolarData = SolarData(LocalDateTime.now(), LocalDateTime.now())
        }
    }
