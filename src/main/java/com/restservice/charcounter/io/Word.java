package com.restservice.charcounter.io;

import lombok.*;
import jakarta.validation.constraints.Size;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Word {

    @NonNull
    @Size(min = 1, max = 100, message =
            "Input string must be must be equal to or greater than 1 character and less than 100 characters")
    private String input;

}
