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

    /**
     * Updates a booking selected by the ID
     *
     * @param newBookingModel the booking the user just sent
     * @param id of the Booking that needs to be updated
     * @return updated booking
     */
    public BookingModel updateBooking(BookingModel newBookingModel, Long id){

        BookingModel oldBookingModel = bookingJpa.findById(id).orElseThrow();

        oldBookingModel.setCost(newBookingModel.getCost());
        oldBookingModel.setBudget(newBookingModel.getBudget());
        oldBookingModel.setConsultationDate(newBookingModel.getConsultationDate());
        oldBookingModel.setContactStartTime(newBookingModel.getContactStartTime());
        oldBookingModel.setContactEndTime(newBookingModel.getContactEndTime());

        bookingJpa.save(oldBookingModel);

        return oldBookingModel;

    }

    /**
     * Deletes a booking by its associated id
     *
     * @param id of the booking we want to delete
     */
    public void deleteBooking(Long id){
        bookingJpa.deleteById(id);
    }


}
