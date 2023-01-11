package com.example.events.model;

import javax.persistence.*;

@Entity(name = "Event")
@Table(name = "event")
public class EventModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long eventId;

    private String typeOfEvent;
    private String dateOfEvent;
    private String timeOfEvent;
    private String designOrPlanning;
    private String city;
    private int headCount;
    private double budget;

    //TODO: Add event to booking many to one

    public EventModel() {
    }

    public EventModel(Long eventId, String typeOfEvent, String dateOfEvent, String timeOfEvent, String designOrPlanning,
                      String city, int headCount, double budget) {
        this.eventId = eventId;
        this.typeOfEvent = typeOfEvent;
        this.dateOfEvent = dateOfEvent;
        this.timeOfEvent = timeOfEvent;
        this.designOrPlanning = designOrPlanning;
        this.city = city;
        this.headCount = headCount;
        this.budget = budget;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public String getTypeOfEvent() {
        return typeOfEvent;
    }

    public void setTypeOfEvent(String typeOfEvent) {
        this.typeOfEvent = typeOfEvent;
    }

    public String getDateOfEvent() {
        return dateOfEvent;
    }

    public void setDateOfEvent(String dateOfEvent) {
        this.dateOfEvent = dateOfEvent;
    }

    public String getTimeOfEvent() {
        return timeOfEvent;
    }

    public void setTimeOfEvent(String timeOfEvent) {
        this.timeOfEvent = timeOfEvent;
    }

    public String getDesignOrPlanning() {
        return designOrPlanning;
    }

    public void setDesignOrPlanning(String designOrPlanning) {
        this.designOrPlanning = designOrPlanning;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getHeadCount() {
        return headCount;
    }

    public void setHeadCount(int headCount) {
        this.headCount = headCount;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }
}
