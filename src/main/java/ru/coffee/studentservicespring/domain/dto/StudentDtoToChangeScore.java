package ru.coffee.studentservicespring.domain.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import ru.coffee.studentservicespring.domain.model.Classroom;

@Getter
@Setter
public class StudentDtoToChangeScore {
    @NotBlank
    String name;
    @NotBlank
    String lastName;
    @NotBlank
    String lesson;
    @Min(1)
    int classroom;
    @Min(1) @Max(5)
    int score;

}
