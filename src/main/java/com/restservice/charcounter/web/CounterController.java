package com.restservice.charcounter.web;

import com.restservice.charcounter.io.Word;
import com.restservice.charcounter.service.CounterService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class CounterController {

    CounterService counterService;
    @Autowired
    public CounterController(CounterService counterService) {
        this.counterService = counterService;
    }

    @PostMapping("/letter-count")
    @Operation(summary = "Get a string and find all occurrences of letters in it")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "All occurrences found and sorted",
            content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Word.class))}),
            @ApiResponse(responseCode = "400", description = "String is empty/null or without letters",
            content = @Content)
    })
    public Map <Character, Integer> countCharacters(@ParameterObject @RequestBody @Valid Word word) {
        Map<Character, Integer> unsorted = counterService.countLetters(word.getInput());
        return counterService.sortMapOfLetters(unsorted);
    }

}
