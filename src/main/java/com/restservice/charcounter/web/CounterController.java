package com.restservice.charcounter.web;

import com.restservice.charcounter.io.Word;
import com.restservice.charcounter.service.CounterService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class CounterController {

    CounterService counterService;


    @PostMapping("/letter-count")
    public Map <Character, Integer> countCharacters(@Valid @ RequestBody Word word) {
        Map<Character, Integer> unsorted = counterService.countLetters(word.getInput());
        return counterService.sortMapOfLetters(unsorted);
    }

}
