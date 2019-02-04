package coding.squid.kotlin.controller

import coding.squid.kotlin.domain.BookingTransaction
import coding.squid.kotlin.service.BookingService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class BookingController(private val bookingService: BookingService) {

    @GetMapping("booking/{id}")
    fun retrieveBookingTransaction(@PathVariable(name = "id") id: Long): Long {
        return bookingService.getBookingTransaction(id).id
    }
}