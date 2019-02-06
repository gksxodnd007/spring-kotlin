package coding.squid.kotlin.domain

import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "tb_user")
data class User private constructor(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var Id: Int?,
        @Column(name = "name")
        var name: String,
        @Column(name = "age")
        var age: Int,
        @Column(name = "registered_at")
        var registeredAt: LocalDateTime
) {
    private constructor(name: String, age: Int): this(null, name, age, LocalDateTime.now())

    companion object {

        fun createUser(name: String, age: Int): User {
            return User(name, age)
        }
    }

    @PrePersist
    fun onPersist() {
        this.registeredAt = LocalDateTime.now()
    }
}