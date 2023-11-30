package com.restservice.charcounter.io;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import jakarta.validation.constraints.Size;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Word {

    @NotBlank(message = "Input cannot be blank")
    @Size(min = 2, max = 100, message =
            "Input string must be must be equal to or greater than 2 character and less than 100 characters")
    @Pattern(regexp = "^[{a-zA-Z}]{2,100}$")
    private String input;

}
