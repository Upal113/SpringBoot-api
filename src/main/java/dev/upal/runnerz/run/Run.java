package dev.upal.runnerz.run;
import java.time.LocalDateTime;
import java.util.List;

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

    public List<Run> runs() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'runs'");
    }
}
