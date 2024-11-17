package dev.upal.runnerz.run;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;

@Repository
public class RunRepository {
    private List<Run> runs = new ArrayList<>();
    
    List<Run> findall() {
        return runs;
    }

    Run findbyid(int id) {
        return runs.stream().filter(
            run -> run.id() == id
        ).findFirst().get(); }

    @PostConstruct
    private void init() {
        // Initialize the repository with some data
        runs.add(new Run(1, "Test", LocalDateTime.now(), LocalDateTime.now().plus(1, ChronoUnit.HOURS), 5, dev.upal.runnerz.run.Location.INDOOR));
        runs.add(new Run(2, "Test2", LocalDateTime.now(), LocalDateTime.now().plus(2, ChronoUnit.HOURS), 10, dev.upal.runnerz.run.Location.OUTDOOR));
        runs.add(new Run(0, null, null, null, 0, null));
        
        
    }
}