package ru.coffee.studentservicespring.domain.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Setter
@Getter
@ToString
@RequiredArgsConstructor
public class StudentDtoWithAverageScore {
    @NotBlank
    private String name;
    @NotBlank
    private String lastName;
    @Min(1) @Max(12)
    private int classroom;
    private int average;

    public StudentDtoWithAverageScore(String name, String lastName, int classroom, int average) {
        this.name = name;
        this.lastName = lastName;
        this.classroom = classroom;
        this.average = average;
    }
}

