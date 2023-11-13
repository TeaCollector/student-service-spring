package ru.coffee.studentservicespring.domain.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class StudentDtoToChangeMark {
    @NotBlank
    String name;
    @NotBlank
    String lastName;
    @NotBlank
    String lesson;
    @Min(1) @Max(5)
    int score;
    @Min(1)
    int classroom;
}
