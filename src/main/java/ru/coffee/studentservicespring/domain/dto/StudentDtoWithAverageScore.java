package ru.coffee.studentservicespring.domain.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class StudentDtoWithAverageScore {
    @NotBlank
    String name;
    @NotBlank
    String lastName;
    @Min(1) @Max(12)
    int classroom;
    double average;
}
