package com.example.events.controller;



import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.example.events.model.EventModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.*;
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
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class EventControllerTest {


    @Autowired
    private MockMvc mockMvc;

    /**
     * Test the post mapping addEvents
     *
     * @StatusCode 201 created
     */
    @Test
    @Order(1)
    public void addEvent() throws Exception{

        mockMvc.perform(MockMvcRequestBuilders
                        .post("/event/event")
                        .content(asJsonString(new EventModel(null, "Birthday Party", "01/01/24", "3:30pm", "planning",
                                "cranston", 10, 300.00)))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.eventId").exists());


    }

    /**
     * Tests getEvent and checks for a random Event for their id and cost
     *
     * @StatusCode 200 Ok
     */
    @Test
    @Order(2)
    public void getEvents() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/event/event/")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("[0].eventId").value("1"))
                .andExpect(MockMvcResultMatchers.jsonPath("[0].typeOfEvent").value("Birthday Party"));

    }

    /**
     * Tests getEventById and checks object is created by checking for existing ID
     *
     * @StatusCode 200 Ok
     */
    @Test
    @Order(3)
    void getEventById() throws Exception{

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/event/event/{id}", 1)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.eventId").value(1));
    }

    /**
     * Test the update mapping in the Event controller
     *
     * @StatusCode 200 Ok
     */
    @Test
    @Order(4)
    void updateEvent() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders
                        .put("/event/event/{id}", 1)
                        .content(asJsonString(new EventModel(null, "Birthday Party", "01/02/24", "3:40pm", "planning",
                                "cranston", 12, 400.00)))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.timeOfEvent").value("3:40pm"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.dateOfEvent").value("01/02/24"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.headCount").value(12))
                .andExpect(MockMvcResultMatchers.jsonPath("$.budget").value(400));

    }


    /**
     * Test Delete mapping in the Event controller
     *
     * @StatusCode 204 No Content
     */
    @Test
    @Order(5)
    void deleteEvent() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.delete("/event/event/{id}", 1))
                .andExpect(status().isNoContent());
    }


    /**
     * Receives a java object and converts it into a JSON string
     *
     * @param obj The Java object we wish to convert
     * @return The object as a JSON string
     */
    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}