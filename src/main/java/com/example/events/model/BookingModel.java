package com.example.events.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.*;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BookingModel {

    @Id
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

    public long getBookingId() {
        return bookingId;
    }

    public void setBookingId(long bookingId) {
        this.bookingId = bookingId;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public LocalDateTime getConsultationDate() {
        return consultationDate;
    }

    public void setConsultationDate(LocalDateTime consultationDate) {
        this.consultationDate = consultationDate;
    }

    // public Event getEvent() {
    //   return event;
    // }

    // public void setEvent(Event event) {
    //   this.event = event;
    // }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public LocalTime getContactStartTime() {
        return contactStartTime;
    }

    public void setContactStartTime(LocalTime contactStartTime) {
        this.contactStartTime = contactStartTime;
    }

    public LocalTime getContactEndTime() {
        return contactEndTime;
    }

    public void setContactEndTime(LocalTime contactEndTime) {
        this.contactEndTime = contactEndTime;
    }
}