/**
 * This is the Data Access Object for Client, providing functionality to assist API.
 */
package com.example.events.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.events.model.ClientModel;

@Repository
public interface ClientJpa extends JpaRepository<ClientModel, Long> {

}
