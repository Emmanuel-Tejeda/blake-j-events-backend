package com.example.events.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.*;
import javax.persistence.*;

@Entity
@Table(name = "BOOKINGS")
public class BookingModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long bookingId;
    private double cost;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="America/New_York")
    private LocalDateTime consultationDate;
    // Client will have any number of Bookings
    // private Event event;
    private double budget;
    @JsonFormat(pattern="HH:mm:ss", timezone="America/New_York")
    private LocalTime contactStartTime;
    @JsonFormat(pattern="HH:mm:ss", timezone="America/New_York")
    private LocalTime contactEndTime;

    // Getters and Setters

    /**
     * Returns the booking ID
     *
     * @return The ID of the Booking
     */
    public long getBookingId() {
        return bookingId;
    }

    /**
     * Sets the booking ID
     *
     * @param bookingId - The ID we wish to set it to
     */
    public void setBookingId(long bookingId) {
        this.bookingId = bookingId;
    }

    /**
     * Returns the booking cost
     *
     * @return The cost of the booking
     */
    public double getCost() {
        return cost;
    }

    /**
     * Sets the booking cost
     *
     * @param cost - The cost we wish to set it to
     */
    public void setCost(double cost) {
        this.cost = cost;
    }

    /**
     * Returns the booking consultation date
     *
     * @return The consultation date of the booking
     */
    public LocalDateTime getConsultationDate() {
        return consultationDate;
    }

    /**
     * Sets the consultation date
     *
     * @param consultationDate - The consulation date we wish to set it to
     */
    public void setConsultationDate(LocalDateTime consultationDate) {
        this.consultationDate = consultationDate;
    }

    //TODO add Event relationship.

    // public Event getEvent() {
    //   return event;
    // }

    // public void setEvent(Event event) {
    //   this.event = event;
    // }

    /**
     * Returns the booking budget
     *
     * @return The budget of the booking
     */
    public double getBudget() {
        return budget;
    }

    /**
     * Sets the booking budget
     *
     * @param budget - The budget we wish to set it to
     */
    public void setBudget(double budget) {
        this.budget = budget;
    }

    /**
     * Returns the bookings call availability start time
     *
     * @return The call availability start time of the booking
     */
    public LocalTime getContactStartTime() {
        return contactStartTime;
    }

    /**
     * Sets the bookings call availability start time
     *
     * @param contactStartTime - The bookings call availability start time we wish to set it to
     */
    public void setContactStartTime(LocalTime contactStartTime) {
        this.contactStartTime = contactStartTime;
    }

    /**
     * Returns the bookings call availability end time
     *
     * @return The call availability start end of the booking
     */
    public LocalTime getContactEndTime() {
        return contactEndTime;
    }

    /**
     * Sets the bookings call availability end time
     *
     * @param contactEndTime - The bookings call availability end time we wish to set it to
     */
    public void setContactEndTime(LocalTime contactEndTime) {
        this.contactEndTime = contactEndTime;
    }
}