package com.example.events.service;

import com.example.events.dao.EventJpa;
import com.example.events.model.EventModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    @Autowired
    EventJpa eventJpa;

    /**
     * Queries the database for the EventModel with the matching ID
     *
     * @param id of the Event we want to get
     * @return requested EventModel Object
     */
    public EventModel getEventById(Long id){
        return eventJpa.findById(id).orElseThrow();
    }

    /**
     * Gets a list of Events
     *
     * @return List of EventModel
     */
    public List<EventModel> getEvents(){
        return eventJpa.findAll();
    }

    /**
     * Saves the Event we add
     *
     * @param EventModel the Event we want to save
     * @return The saved Event
     */
    public EventModel saveEvent(EventModel EventModel){

        return eventJpa.save(EventModel);
    }

    /**
     * Updates a Event selected by the ID
     *
     * @param newEventModel the Event the user just sent
     * @param id of the Event that needs to be updated
     * @return updated Event
     */
    public EventModel updateEvent(EventModel newEventModel, Long id){

        EventModel oldEventModel = eventJpa.findById(id).orElseThrow();

        oldEventModel.setDateOfEvent(newEventModel.getDateOfEvent());
        oldEventModel.setTimeOfEvent(newEventModel.getTimeOfEvent());
        oldEventModel.setTypeOfEvent(newEventModel.getTypeOfEvent());
        oldEventModel.setBudget(newEventModel.getBudget());
        oldEventModel.setCity(newEventModel.getCity());
        oldEventModel.setHeadCount(newEventModel.getHeadCount());
        oldEventModel.setDesignOrPlanning(newEventModel.getDesignOrPlanning());

        eventJpa.save(oldEventModel);

        return oldEventModel;

    }

    /**
     * Deletes a Event by its associated id
     *
     * @param id of the Event we want to delete
     */
    public void deleteEvent(Long id){
        eventJpa.deleteById(id);
    }
}
