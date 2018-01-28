package ddd.guild.courtbooking.application.schedule

import ddd.guild.courtbooking.domain.schedule.Booking
import ddd.guild.courtbooking.domain.schedule.TimeSlot
import org.springframework.stereotype.Service

@Service
class BookingService(val bookingRepository: BookingRepository) {

    fun createBooking(c: BookingCommands.CreateBooking): String {
        val bookingId = bookingRepository.nextIdentity()
        val booking = Booking(bookingId, c.memberId, c.courtId, c.day, TimeSlot(c.startTime, c.endTime))

        bookingRepository.save(booking)

        return bookingId
    }

    fun cancelBooking(c: BookingCommands.CancelBooking) {
        val booking = bookingRepository.findById(c.bookingId).get()

        booking.cancel(c.userId)

        bookingRepository.save(booking)
    }

    fun confirmBooking(c: BookingCommands.ConfirmBooking) {
        val booking = bookingRepository.findById(c.bookingId).get()

        booking.confirm(c.userId)

        bookingRepository.save(booking)
    }
}