package ddd.guild.courtbooking.application.schedule

import ddd.guild.courtbooking.domain.schedule.Booking
import org.springframework.data.repository.Repository
import java.util.*

interface BookingRepository : Repository<Booking, String> {
    fun save(booking: Booking): Booking

    /**
     * Queries
     */
    fun findAll(): List<Booking>

    fun findById(id: String): Optional<Booking>
}

fun BookingRepository.nextIdentity(): String {
    return java.util.UUID.randomUUID().toString()
}
