/**
 * This is the Client Model, representing a client.
 */
package com.example.events.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity(name = "Clients")
@Table(name = "clients")
public class ClientModel {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long clientId;
  private String clientFirstName;
  private String clientLastName;
  private String clientPhoneNumber;
  private String clientEmail;

  @OneToMany(
          mappedBy = "myClient",
          cascade = CascadeType.ALL,
          orphanRemoval = true
  )
  @JsonManagedReference
  private List<BookingModel> clientBookings;

  public ClientModel() {
  }


  public ClientModel(Long clientId, String clientFirstName, String clientLastName, String clientPhoneNumber, String clientEmail, List<BookingModel> clientBookings) {
    this.clientId = clientId;
    this.clientFirstName = clientFirstName;
    this.clientLastName = clientLastName;
    this.clientPhoneNumber = clientPhoneNumber;
    this.clientEmail = clientEmail;
    this.clientBookings = clientBookings;
  }

  // Getters and Setters
  /**
   * Returns the client ID
   * 
   * @return The ID of the client
   */
  public Long getClientId() {
    return clientId;
  }

  /**
   * Sets the client ID
   * 
   * @param clientId - The ID we wish to set it to
   */
  public void setClientId(Long clientId) {
    this.clientId = clientId;
  }

  /**
   * Returns the client's first name
   * 
   * @return The client's first name
   */
  public String getClientFirstName() {
    return clientFirstName;
  }

  /**
   * Sets the client's first name
   * 
   * @param clientFirstName - What the client's first name will be set to
   */
  public void setClientFirstName(String clientFirstName) {
    this.clientFirstName = clientFirstName;
  }

  /**
   * Returns the client's last name
   * 
   * @return The client's last name
   */
  public String getClientLastName() {
    return clientLastName;
  }

  /**
   * Sets the client's last name
   * 
   * @param clientLastName - What the client's last name will be set to
   */
  public void setClientLastName(String clientLastName) {
    this.clientLastName = clientLastName;
  }

  /**
   * Returns the client's phone number
   * 
   * @return The client's phone number
   */
  public String getClientPhoneNumber() {
    return clientPhoneNumber;
  }

  /**
   * Sets the client's phone number
   * 
   * @param clientPhoneNumber - What the client's phone number will be set to
   */
  public void setClientPhoneNumber(String clientPhoneNumber) {
    this.clientPhoneNumber = clientPhoneNumber;
  }

  /**
   * Returns the client's email address
   * 
   * @return The client's email address
   */
  public String getClientEmail() {
    return clientEmail;
  }

  /**
   * Sets the client's email address
   * 
   * @param clientEmail - What the client's email address will be set to
   */
  public void setClientEmail(String clientEmail) {
    this.clientEmail = clientEmail;
  }

  public List<BookingModel> getClientBookings() {
    return clientBookings;
  }

  public void setClientBookings(List<BookingModel> clientBookings) {
    this.clientBookings = clientBookings;
  }

  /**
   * adds a booking from the client
   *
   * @param booking the booking we want to remove
   */
  public void addBooking(BookingModel booking) {
    this.clientBookings.add(booking);
    booking.setMyClient(this);
  }

  /**
   * removes a booking from the client
   *
   * @param booking
   */
  public void removeComment(BookingModel booking) {
    this.clientBookings.remove(booking);
    booking.setMyClient(null);
  }

}
