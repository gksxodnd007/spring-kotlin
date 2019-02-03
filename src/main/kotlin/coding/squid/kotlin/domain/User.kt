package coding.squid.kotlin.domain

import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "tb_user")
class User(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var Id: Int?,
        @Column(name = "name")
        var name: String?,
        @Column(name = "age")
        var age: Int?,
        @Column(name = "registered_at")
        var registeredAt: LocalDateTime?
) {

    fun registerName(name: String) {
        this.name = name
    }

    fun registerAge(age: Int) {
        this.age = age
    }

    @PrePersist
    fun onPersist() {
        this.registeredAt = LocalDateTime.now()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is User) return false

        if (Id != other.Id) return false
        if (name != other.name) return false
        if (age != other.age) return false
        if (registeredAt != other.registeredAt) return false

        return true
    }

    override fun hashCode(): Int {
        var result = Id ?: 0
        result = 31 * result + (name?.hashCode() ?: 0)
        result = 31 * result + (age ?: 0)
        result = 31 * result + (registeredAt?.hashCode() ?: 0)
        return result
    }

    override fun toString(): String {
        return "User(Id=$Id, name=$name, age=$age, registeredAt=$registeredAt)"
    }
}