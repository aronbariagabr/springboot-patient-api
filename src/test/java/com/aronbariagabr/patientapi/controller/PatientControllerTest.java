package com.aronbariagabr.patientapi.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class PatientControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testAddPatient() throws Exception {
        mockMvc.perform(post("/patients")
            .contentType(MediaType.APPLICATION_JSON)
            .content("{\"id\":1,\"name\":\"Alice\",\"age\":30}"))
            .andExpect(status().isOk());
    }
}
