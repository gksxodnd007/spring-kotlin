package coding.squid.kotlin.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HealthChecker {

    @GetMapping("/api/health-check")
    fun healthCheck(): String = "i'm running"
}
