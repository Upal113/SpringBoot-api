package dev.upal.runnerz.run;
import java.time.LocalDateTime;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

public record Run(
    int id,
    @NotEmpty
    String title,
    LocalDateTime startedOn,
    LocalDateTime completedOn,
    @Positive
    int miles,
    Location location
) {

    public Run {
        if (startedOn.isAfter(completedOn)) {
            throw new IllegalArgumentException("Started on date cannot be after completed on date");
            }
    }
}
