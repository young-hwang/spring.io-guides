package com.example.restfulwebservice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
class GreetingControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void greeting() throws Exception {
        // given
        // when
        // then
        mockMvc.perform(get("/greeting").param("name", "Spring"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content").value("Hello, Spring!"));
    }
}