package com.example.events.model;

import javax.persistence.*;

@Entity(name = "Event")
@Table(name = "event")
public class EventModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long eventId;



}
