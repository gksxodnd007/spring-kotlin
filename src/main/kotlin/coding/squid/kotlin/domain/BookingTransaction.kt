package coding.squid.kotlin.domain

import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "tb_booking_transaction")
data class BookingTransaction(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long,
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "user_id", foreignKey = ForeignKey(ConstraintMode.NO_CONSTRAINT))
        var user: User,
        @Column(name = "booked_at")
        var bookedAt: LocalDateTime
) {
    @PrePersist
    fun onPersist() {
        this.bookedAt = LocalDateTime.now()
    }
}