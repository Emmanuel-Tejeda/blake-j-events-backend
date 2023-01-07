package com.example.events.service;

import com.example.events.dao.BookingJpa;
import com.example.events.dao.ClientJpa;
import com.example.events.model.BookingModel;
import com.example.events.model.ClientModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientJpa clientJpa;

    @Autowired
    private BookingJpa bookingJpa;

    /**
     * Queries the database for the ClientModel with the matching ID
     *
     * @param id the Id of the Client we want to get
     * @return requested ClientModel Object
     */
    public ClientModel getClientById(Long id){
        return clientJpa.findById(id).orElseThrow();
    }

    /**
     * Gets a list of Clients
     *
     * @return List of ClientModel
     */
    public List<ClientModel> getClients(){
        return clientJpa.findAll();
    }

    /**
     * Saves the Client we add
     *
     * @param ClientModel the Client we want to save
     * @return The saved Client
     */
    public ClientModel saveClient(ClientModel ClientModel){

        return clientJpa.save(ClientModel);
    }

    /**
     * Updates a Client selected by the ID
     *
     * @param newClientModel the Client the user just sent
     * @param id of the Client that needs to be updated
     * @return updated Client
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
     * Deletes a Client by its associated id
     *
     * @param id of the Client we want to delete
     */
    public void deleteClient(Long id){
        clientJpa.deleteById(id);
    }


    /**
     * Adds a booking to the clients booking list
     *
     * @param clientId of the Client
     * @param bookingId the booking we want to add
     */
    public ClientModel addClientBooking(Long clientId, Long bookingId){

        ClientModel client = clientJpa.findById(clientId).orElseThrow();
        BookingModel booking = bookingJpa.findById(bookingId).orElseThrow();

        client.addBooking(booking);
        clientJpa.save(client);

        return client;
    }
}
