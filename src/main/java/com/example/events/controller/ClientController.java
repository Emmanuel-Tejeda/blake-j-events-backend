/**
 * This is the Client Controller, handling defining various REST functionality.
 */
package com.example.events.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.events.dao.ClientJpa;
import com.example.events.model.ClientModel;

@RestController
@RequestMapping(path = "event/client")
public class ClientController {
  // TODO: Uncomment when service is available
  // private final clientService;

  // @Autowired
  // public ClientController(ClientService clientService)
  // {
  // this.clientService = clientService;
  // }

  @Autowired
  ClientJpa clientJpa;

  /**
   * Gets a client given some id
   * 
   * @param sid - The id of the client we wish to get
   * @return The Optional<ClientModel>, or error
   */
  // TODO: Add logic for if we fail (network error, client doesn't exist)
  @GetMapping(path = "{id}")
  public Optional<ClientModel> getClientById(@PathVariable("id") Long sid) {
    // return clientService.getStudent(sid);
    return clientJpa.findById(sid);
  }

  /**
   * Adds a new client into the database
   * 
   * @param newClient - The client we wish to add
   * @return The client we added if successful, otherwise some error
   */
  // TODO: Add logic for if we fail (client already exists, some other error)
  @PostMapping
  public Optional<ClientModel> addClient(@RequestBody ClientModel newClient) {
    // return clientService.addClient(newClient);
    clientJpa.save(newClient);
    return clientJpa.findById(newClient.getClientId());
  }

  // TODO: Uncomment and have appropriate PUT logic in the service layer
  // @PutMapping(path = "{id}")
  // public Optional<ClientModel> updateClient(
  // @PathVariable("id") Long sid,
  // @RequestBody ClientModel updatedClient) {
  // // return clientService.updateClient(sid, updatedClient);

  // }

  /**
   * Deletes a client from the database
   * 
   * @param sid - The id of the client we wan tto delete
   * @return The client we deleted
   */
  @DeleteMapping(path = "{id}")
  public Optional<ClientModel> deleteClient(@PathVariable("id") Long sid) {
    // return clientService.deleteClient(sid);
    boolean exists = clientJpa.existsById(sid);
    if (!exists) {
      throw new IllegalStateException("Client with id " + sid + "does not exist");
    }
    Optional<ClientModel> deletedClient = clientJpa.findById(sid);
    clientJpa.deleteById(sid);
    return deletedClient;
  }
}
