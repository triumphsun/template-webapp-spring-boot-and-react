package com.suntri.demo.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest
public class DemoControllerIntegrationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldEchoTheSameName() throws Exception{
        String name = "hello world";
        this.mockMvc.perform(
                MockMvcRequestBuilders
                    .get("/api/echo")
                    .queryParam("name", name)
            )
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.header().string(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE))
            .andExpect(MockMvcResultMatchers.jsonPath("$.name").value(name))
            .andExpect(MockMvcResultMatchers.jsonPath("$.timestamp").exists());
    }
}
