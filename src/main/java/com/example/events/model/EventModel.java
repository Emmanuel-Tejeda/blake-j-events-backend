package com.example.events.model;

import javax.persistence.*;

@Entity(name = "Event")
@Table(name = "event")
public class EventModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long eventId;

    private String typeOfEvent;
    private String dateofEvent;
    private String timeOfEvent;
    private String designOrPlanning;
    private String city;
    private String headCount;
    private double budget;

    public EventModel() {
    }

    public EventModel(Long eventId, String typeOfEvent, String dateofEvent, String timeOfEvent, String designOrPlanning,
                      String city, String headCount, double budget) {
        this.eventId = eventId;
        this.typeOfEvent = typeOfEvent;
        this.dateofEvent = dateofEvent;
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

    public String getDateofEvent() {
        return dateofEvent;
    }

    public void setDateofEvent(String dateofEvent) {
        this.dateofEvent = dateofEvent;
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

    public String getHeadCount() {
        return headCount;
    }

    public void setHeadCount(String headCount) {
        this.headCount = headCount;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }
}
