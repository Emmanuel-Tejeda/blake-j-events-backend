package com.example.events.controller;

import com.example.events.model.EventModel;
import com.example.events.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class EventController {

    @Autowired
    EventService eventService;

    /**
     * Adds a new Event into the database
     *
     * @param id - The id of the Event we are looking for
     * @return The Event if found in the database
     * @StatusCode Returns a 200 status code connection established
     */
    @GetMapping("event/event/{id}")
    public ResponseEntity<EventModel> getEventById(@PathVariable("id") Long id) {
        try {
            return new ResponseEntity<EventModel>(eventService.getEventById(id), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<EventModel>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Returns all the Events in database
     *
     * @return All the Events as a list of type EventModel
     * @StatusCode 200 Ok | 404 Not Found
     */
    @GetMapping("event/event")
    public ResponseEntity<List> getEvents () {

        try {
            return new ResponseEntity<>(eventService.getEvents(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     *
     * @param newEvent - New Event to be added to the database
     * @return The new Event if added to the database succesfully
     * @StatusCode 201 Created || 400 Bad Request
     */
    @PostMapping("event/event")
    public ResponseEntity<EventModel> addEvent (@Valid @RequestBody EventModel newEvent){

        try {
            eventService.saveEvent(newEvent);
            return new ResponseEntity<EventModel>(newEvent, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<EventModel>(newEvent, HttpStatus.BAD_REQUEST);
        }
    }

    /**
     *
     * @param newEvent The Event that the user updated
     * @param id The id of the Event that requires an update
     * @return Response Entity
     * @StatusCode 200 Updated || 204 Not Found
     */
    @PutMapping("event/event/{id}")
    public ResponseEntity<EventModel> updateEvent (@Valid @RequestBody EventModel
                                                             newEvent, @PathVariable Long id){

        try {
            eventService.updateEvent(newEvent, id);
            return new ResponseEntity<EventModel>(newEvent, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<EventModel>(HttpStatus.NO_CONTENT);
        }
    }

    /**
     *
     * @param id of EventModel to be deleted
     * @return Status code
     * @StatusCode 204 No Content || 404 Not Found
     */
    @DeleteMapping("event/event/{id}")
    public ResponseEntity<EventModel> deleteEvent (@PathVariable Long id) throws Exception {

        try {
            eventService.deleteEvent(id);
            return new ResponseEntity<EventModel>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
