package coding.squid.kotlin.service

import coding.squid.kotlin.domain.BookingTransaction
import coding.squid.kotlin.repository.BookingRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class BookingService(private val bookingRepository: BookingRepository) {

    @Transactional(readOnly = true)
    fun getBookingTransaction(id: Long): BookingTransaction {
        return bookingRepository.findById(id).orElseThrow { RuntimeException("Not found bookingTransaction") }
    }
}