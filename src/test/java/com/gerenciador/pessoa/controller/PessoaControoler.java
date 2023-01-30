package com.gerenciador.pessoa.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.gerenciador.pessoa.dtos.PeopleDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import javax.transaction.Transactional;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class PessoaControoler {

    @Autowired
    private MockMvc mockMvc;


    @Autowired
    private ObjectMapper objectMapper;

    private Long existingId;
    private Long nonExistingId;
    private Long countTotalPeoples;
    private PeopleDTO peopleDTO;


    @Test
    public void updateShouldReturn() throws Exception {

        String jsonBody = objectMapper.writeValueAsString(peopleDTO);
        ResultActions result = mockMvc.perform(put("/pessoa/{id}", nonExistingId).content(jsonBody)
                .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON));

        result.andExpect(status().isNotFound());
    }

    @Test
    public void updateShouldReturnPeople() throws Exception {

        String jsonBody = objectMapper.writeValueAsString(peopleDTO);
        String expectedName = peopleDTO.getName();
        ResultActions result = mockMvc.perform(put("/api/pessoa/{id}", existingId).content(jsonBody)
                .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON));
        result.andExpect(status().isOk());
        result.andExpect(jsonPath("$.id").value(existingId));
        result.andExpect(jsonPath("$.name").value(expectedName));

    }

}
