package com.example.events.service;

import com.example.events.dao.ClientJpa;
import com.example.events.model.ClientModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientJpa clientJpa;

    /**
     * Queries the database for the ClientModel with the matching ID
     *
     * @param id the Id of the Booking we want to get
     * @return requested ClientModel Object
     */
    public ClientModel getBookingById(Long id){
        return clientJpa.findById(id).orElseThrow();
    }

    /**
     * Gets a list of Bookings
     *
     * @return List of ClientModel
     */
    public List<ClientModel> getBookings(){
        return clientJpa.findAll();
    }

    /**
     * Saves the booking we add
     *
     * @param ClientModel the booking we want to save
     * @return The saved booking
     */
    public ClientModel saveBooking(ClientModel ClientModel){

        return clientJpa.save(ClientModel);
    }

    /**
     * Updates a booking selected by the ID
     *
     * @param newClientModel the booking the user just sent
     * @param id of the Booking that needs to be updated
     * @return updated booking
     */
    public ClientModel updateClient(ClientModel newClientModel, Long id){

        ClientModel oldClientModel = clientJpa.findById(id).orElseThrow();

        oldClientModel.setClientEmail(newClientModel.getClientEmail());
        oldClientModel.setClientFirstName(newClientModel.getClientFirstName());
        oldClientModel.setClientLastName(newClientModel.getClientLastName());
        oldClientModel.setClientPhoneNumber(newClientModel.getClientPhoneNumber());



        clientJpa.save(oldClientModel);

        return oldClientModel;

    }

    /**
     * Deletes a booking by its associated id
     *
     * @param id of the booking we want to delete
     */
    public void deleteBooking(Long id){
        clientJpa.deleteById(id);
    }
}
