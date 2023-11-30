package com.restservice.charcounter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.restservice.charcounter.io.Word;
import com.restservice.charcounter.service.CounterService;
import com.restservice.charcounter.web.CounterController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.*;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

@WebMvcTest(controllers = CounterController.class)
public class CounterControllerTest {
    private Word word;
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    CounterService counterService;
    @BeforeEach
    void setup() {
        word = new Word();
    }
    @Test
    @DisplayName("Input string can be sorted")
    void testCountCharacters_whenValidStringProvided_return200Status() throws Exception {
        //Arrange
        word.setInput("aabbbbc");

        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/letter-count")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(word));
        //Act
        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();

        //Assert
        assertEquals(HttpStatus.OK.value(), mvcResult.getResponse().getStatus());
    }
    @Test
    @DisplayName("Input string is not empty")
    void testCountCharacters_whenInValidStringProvided_return400Status() throws Exception {
        //Arrange
        word.setInput("");

        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/letter-count")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(word));
        //Act
        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();

        //Assert
        assertEquals(HttpStatus.BAD_REQUEST.value(), mvcResult.getResponse().getStatus());
    }


}
