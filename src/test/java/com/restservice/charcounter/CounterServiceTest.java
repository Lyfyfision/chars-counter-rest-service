package com.restservice.charcounter;


import com.restservice.charcounter.io.Word;
import com.restservice.charcounter.service.CounterService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;


public class CounterServiceTest {
    private Map<Character, Integer> mapToAssert;
    private CounterService counterService;
    private Word word;

    @BeforeEach
    void setup() {
        this.counterService = new CounterService();
        word = new Word();
        String usersInput = "aaaabbcccc";
        word.setInput(usersInput);
        mapToAssert = new HashMap<>();
        mapToAssert.put('a', 4);
        mapToAssert.put('b', 2);
        mapToAssert.put('c', 4);
    }

    @Test
    @DisplayName("Characters has been counted")
    void testCountCharactersInString_whenGivenCorrectString_returnUnsortedMapOfOccurrences() {
        //Arrange
        Map<Character, Integer> unsortedMap = counterService.countLetters(word.getInput());

        //Assert
        assertEquals(unsortedMap, mapToAssert);
    }
}
