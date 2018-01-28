package ddd.guild.courtbooking.application.schedule

import java.time.LocalDate
import java.time.LocalTime

sealed class BookingCommands {
    class CreateBooking(val courtId: String,
                        val day: LocalDate,
                        val startTime: LocalTime,
                        val endTime: LocalTime,
                        val memberId: String) : BookingCommands()

    class CancelBooking(val bookingId: String, val userId: String) : BookingCommands()

    class ConfirmBooking(val bookingId: String, val userId: String) : BookingCommands()
}
