package com.example.events.controller;



import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.example.events.model.ClientModel;
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
class ClientControllerTest {


    @Autowired
    private MockMvc mockMvc;

    /**
     * Test the post mapping addClients
     *
     * @StatusCode 201 created
     */
    @Test
    @Order(1)
    public void addClient() throws Exception{

        mockMvc.perform(MockMvcRequestBuilders
                        .post("/event/client")
                        .content(asJsonString(new ClientModel(null, "Emmanuel", "Tejeda", "401-481-5645","eman@gmail.com")))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.clientId").exists());
        ;

    }

    /**
     * Tests getClient and checks for a random Client for their id and cost
     *
     * @StatusCode 200 Ok
     */
    @Test
    @Order(2)
    public void getClients() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/event/client/")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("[0].clientId").value("1"))
                .andExpect(MockMvcResultMatchers.jsonPath("[0].clientLastName").value("Tejeda"));

    }

    /**
     * Tests getClientById and checks object is created by checking for existing ID
     *
     * @StatusCode 200 Ok
     */
    @Test
    @Order(3)
    void getClientById() throws Exception{

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/event/client/{id}", 1)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.clientId").value(1));
    }

    /**
     * Test the update mapping in the Client controller
     *
     * @StatusCode 200 Ok
     */
    @Test
    @Order(4)
    void updateClient() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders
                        .put("/event/client/{id}", 1)
                        .content(asJsonString(new ClientModel(1L, "Jessabella", "Baez", "401-470-3753","jessie@gmail.com")))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.clientFirstName").value("Jessabella"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.clientLastName").value("Baez"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.clientPhoneNumber").value("401-470-3753"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.clientEmail").value("jessie@gmail.com"));

    }

    /**
     * Test Delete mapping in the Client controller
     *
     * @StatusCode 204 No Content
     */
    @Test
    @Order(5)
    void deleteClient() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.delete("/event/client/{id}", 1))
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