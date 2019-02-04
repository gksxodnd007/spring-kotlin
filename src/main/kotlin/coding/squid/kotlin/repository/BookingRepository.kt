package coding.squid.kotlin.repository

import coding.squid.kotlin.domain.BookingTransaction
import coding.squid.kotlin.domain.User
import org.springframework.data.jpa.repository.JpaRepository

interface BookingRepository: JpaRepository<BookingTransaction, Long> {

    fun findByUser(user: User): List<BookingTransaction>
}