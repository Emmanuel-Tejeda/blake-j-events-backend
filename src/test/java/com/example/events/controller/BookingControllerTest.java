package com.example.events.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.example.events.model.BookingModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


//Setting up SpringBoot test annotations
@SpringBootTest
@AutoConfigureMockMvc
public class BookingControllerTest{

    @Autowired
    private MockMvc mockMvc;

    /**
     * Tests getBooking and checks for a random booking for their id and cost
     * @StatusCode 200 Ok
     */
    @Test
    public void getBookings() throws Exception
    {
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/event/bookings/")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("[4].bookingId").value("5"))
                .andExpect(MockMvcResultMatchers.jsonPath("[4].cost").value("400.0"));

    }

    /**
     * Tests getBookingById and checks object is created by checking for existing ID
     * @StatusCode 200 Ok
     */
    @Test
    public void getBookingsById() throws Exception {

       mockMvc.perform(MockMvcRequestBuilders
               .get("/event/booking/{id}", 1)
               .accept(MediaType.APPLICATION_JSON))
               .andDo(print())
               .andExpect(status().isOk())
               .andExpect(MockMvcResultMatchers.jsonPath("$.bookingId").value(1));
    }

    /**
     * Test the post mapping addBookings
     * @StatusCode 201 created
     */
    @Test
    public void saveBooking() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders
                        .post("/event/booking")
                        .content(asJsonString(new BookingModel(null, 400, "2022-12-24 15:00:00",
                                1000, "08:00:00","14:00:00")))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.bookingId").exists());;

    }

    /**
     * Test the update mapping in the booking controller
     * @StatusCode 200 Ok
     */
    @Test
    public void updateBooking()throws Exception {

        mockMvc.perform(MockMvcRequestBuilders
                        .put("/event/booking/{id}", 2)
                        .content(asJsonString(new BookingModel(2L, 500, "2023-01-23 19:00:00",
                                1234, "10:00:00","17:00:00")))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.cost").value("500.0"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.budget").value("1234.0"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.contactStartTime").value("10:00:00"));

    }



    //Wrties as a json value as a string
    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}

