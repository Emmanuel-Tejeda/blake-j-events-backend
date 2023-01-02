/**
 * This is the Client Controller, handling defining various REST functionality.
 */
package com.example.events.controller;

import java.util.List;

import com.example.events.model.ClientModel;

import com.example.events.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;

@RestController
@RequestMapping(path = "event/client")
public class ClientController {
  // TODO: Uncomment when service is available
  // private final clientService;

  @Autowired
  ClientService clientService;

  /**
   * Adds a new client into the database
   *
   * @param id - The id of the client we are looking for
   * @return The client if found in the database
   * @StatusCode Returns a 200 status code connection established
   */
  @GetMapping("event/client/{id}")
  public ResponseEntity<ClientModel> getClientById(@PathVariable("id") Long id) {
    try {
      return new ResponseEntity<ClientModel>(clientService.getClientById(id), HttpStatus.OK);
    } catch (Exception e) {
      e.printStackTrace();
      return new ResponseEntity<ClientModel>(HttpStatus.NOT_FOUND);
    }
  }

  /**
   * Returns all the clients in database
   *
   * @return All the clients as a list of type ClientModel
   * @StatusCode 200 Ok | 404 Not Found
   */
  @GetMapping("event/client")
  public ResponseEntity<List> getClients () {

    try {
      return new ResponseEntity<>(clientService.getClients(), HttpStatus.OK);
    } catch (Exception e) {
      e.printStackTrace();
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  /**
   *
   * @param newClient - New Client to be added to the database
   * @return The new Client if added to the database succesfully
   * @StatusCode 201 Created || 400 Bad Request
   */
  @PostMapping("event/Client")
  public ResponseEntity<ClientModel> addClient (@Valid @RequestBody ClientModel newClient){

    try {
      clientService.saveClient(newClient);
      return new ResponseEntity<ClientModel>(newClient, HttpStatus.CREATED);
    } catch (Exception e) {
      e.printStackTrace();
      return new ResponseEntity<ClientModel>(newClient, HttpStatus.BAD_REQUEST);
    }
  }

  /**
   *
   * @param newClient The Client that the user updated
   * @param id The id of the Client that requires an update
   * @return Response Entity
   * @StatusCode 200 Updated || 204 Not Found
   */
  @PutMapping("event/Client/{id}")
  public ResponseEntity<ClientModel> updateClient (@Valid @RequestBody ClientModel
                                                             newClient, @PathVariable Long id){

    try {
      clientService.updateClient(newClient, id);
      return new ResponseEntity<ClientModel>(newClient, HttpStatus.OK);
    } catch (Exception e) {
      e.printStackTrace();
      return new ResponseEntity<ClientModel>(HttpStatus.NO_CONTENT);
    }
  }

  /**
   *
   * @param id of ClientModel to be deleted
   * @return Status code
   * @StatusCode 204 No Content || 404 Not Found
   */
  @DeleteMapping("event/Client/{id}")
  public ResponseEntity<ClientModel> deleteClient (@PathVariable Long id) throws Exception {

    try {
      clientService.deleteClient(id);
      return new ResponseEntity<ClientModel>(HttpStatus.NO_CONTENT);
    } catch (Exception e) {
      e.printStackTrace();
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }
}
