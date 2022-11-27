/**
 * This is the Client Model, representing a client.
 */
package com.example.events.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ClientModel {

  //
  @Id
  private Long clientId;
  private String clientFirstName;
  private String clientLastName;
  private String clientPhoneNumber;
  private String clientEmail;
  // TODO: Uncomment when booking model is done.
  // private Set<BookingModel> clientBookings;

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

  // TODO: Uncomment and test all booking related stuff after bookings are there
  // /**
  // * Returns the client's bookings
  // * @returns The set of bookings
  // */
  // public Set<BookingModel> getBookings() {
  // return clientBookings;
  // }

  // /**
  // * Adds a booking for the client
  // * @param booking - The booking to add to the set of bookings
  // */
  // public void addClientBooking(BookingModel newBooking) {
  // clientBookings.add(newBooking);
  // }

  // /**
  // * Removes a booking for the client
  // * @param booking - The booking to remove
  // */
  // public void removeClientBooking(BookingModel booking) {
  // clientBookings.remove(booking);
  // }

  // /**
  // * Overload method for removing bookings, to use id
  // * @param bookingId - The id of the booking to be removed
  // */
  // public void removeClientBooking(Long bookingId) {
  // clientBookings.forEach(booking -> clientBookings.removeIf(o ->
  // o.getBookingId() == booking.getBookingId()));
  // }

}
