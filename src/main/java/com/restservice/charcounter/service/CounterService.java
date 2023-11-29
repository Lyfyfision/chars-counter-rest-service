package com.restservice.charcounter.service;

import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
@Service
public class CounterService {

    public Map<Character, Integer> countLetters(String input) {
        Map<Character, Integer> letterCountMap = new HashMap<>();

        // Count the occurrence of each letter
        for (char c : input.toCharArray()) {
            letterCountMap.put(c, letterCountMap.getOrDefault(c, 0) + 1);
        }

        return letterCountMap;
    }

    public Map<Character, Integer> sortMapOfLetters(Map<Character, Integer> unsortedMap) {
        Map<Character, Integer> sortedMap = new LinkedHashMap<>();
        unsortedMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEachOrdered(entry -> sortedMap.put(entry.getKey(), entry.getValue()));

        return sortedMap;
    }
}
