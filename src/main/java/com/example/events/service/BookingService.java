package com.example.events.service;

import com.example.events.dao.BookingJpa;
import com.example.events.model.BookingModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingJpa bookingJpa;

    /**
     * Queries the database for the BookingModel with the matching ID
     *
     * @param id the Id of the Booking we want to get
     * @return requested BookingModel Object
     */
    public BookingModel getBookingById(Long id){
        return bookingJpa.findById(id).orElseThrow();
    }

    /**
     * Gets a list of Bookings
     *
     * @return List of BookingModel
     */
    public List<BookingModel> getBookings(){
        return bookingJpa.findAll();
    }

    /**
     * Saves the booking we add
     *
     * @param bookingModel the booking we want to save
     * @return The saved booking
     */
    public BookingModel saveBooking(BookingModel bookingModel){
        return bookingJpa.save(bookingModel);
    }


}
