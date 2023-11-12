package ru.coffee.studentservicespring.domain.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import ru.coffee.studentservicespring.domain.model.Classroom;

@Setter
@Getter
public class StudentDtoForAdding {
    @NotBlank
    String name;
    @NotBlank
    String lastName;
    @Min(6)
    int age;
    @Min(1) @Max(12)
    Classroom classroom;
}
