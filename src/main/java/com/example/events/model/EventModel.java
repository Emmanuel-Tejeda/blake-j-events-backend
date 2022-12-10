package com.example.events.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "EVENTS")
public class EventModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long eventId;
    private LocalDateTime eventDate;
    private String eventType;
    private String eventLocation;

    // Getters and Setters

    /**
     * Returns the event ID
     *
     * @return The ID of the event
     */
    public Long getEventId() {
        return eventId;
    }

    /**
     * Sets the event ID
     *
     * @param eventId - The ID we wish to set it to
     */
    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    /**
     * Returns the event date
     *
     * @return The date of the event
     */
    public LocalDateTime getEventDate() {
        return eventDate;
    }

    /**
     * Sets the event date
     *
     * @param eventDate - The date of the event we wish to set it to
     */
    public void setEventDate(LocalDateTime eventDate) {
        this.eventDate = eventDate;
    }

    /**
     * Returns the event type
     *
     * @return The type of the event
     */
    public String getEventType() {
        return eventType;
    }

    /**
     * Sets the event type
     *
     * @param eventType - The type of the event we wish to set it to
     */
    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    /**
     * Returns the event location
     *
     * @return The location of the event
     */
    public String getEventLocation() {
        return eventLocation;
    }

    /**
     * Sets the event location
     *
     * @param eventLocation - The location of the event we wish to set it to
     */
    public void setEventLocation(String eventLocation) {
        this.eventLocation = eventLocation;
    }
}
