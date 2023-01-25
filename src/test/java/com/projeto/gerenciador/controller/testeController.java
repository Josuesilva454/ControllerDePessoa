package com.projeto.gerenciador.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.projeto.gerenciador.entities.Endereco;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class testeController {
    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    // Buscando Api do endereço
    @Test
    public void getAllEnderecoAPI() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                        .get("/endereco")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());

    }
    @Test
    public void getByIdEnderecoAPI() throws Exception {

    // Retornado Id do endereço/
     mvc.perform(MockMvcRequestBuilders
             .get("/endereco/1")
             .accept(MediaType.APPLICATION_JSON))
            .andDo(print())
            .andExpect(status().isOk());
    }

    // Testando Api do endereço
    @Test
    public void SaveEnderecoAPI() throws Exception {


        Endereco endereco = new Endereco();
        endereco.setPessoa(endereco.getPessoa());
        endereco.setIdEndereco(endereco.getIdEndereco());
        endereco.setCep(endereco.getCep());
        endereco.setLogradouro(endereco.getLogradouro());
        endereco.setNumero(endereco.getNumero());

        endereco.setCep("332132");
        endereco.setLogradouro("Rua Dinarah Ferreira Messeder");
        endereco.setNumero(122);


        mvc.perform(MockMvcRequestBuilders
                        .post("/endereco")
                        .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(endereco)))
                .andExpect(status().isOk());




    }
}
