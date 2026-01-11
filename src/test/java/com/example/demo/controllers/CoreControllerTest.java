package com.example.demo.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = CoreController.class)
class CoreControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void helloWithDefaultName() throws Exception {
        mockMvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello World!"));
    }

    @Test
    void helloWithCustomName() throws Exception {
        mockMvc.perform(get("/hello")
                        .param("name", "Manuel"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello Manuel!"));
    }
}
