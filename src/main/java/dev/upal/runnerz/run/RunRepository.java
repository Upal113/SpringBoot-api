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

    // Fetch all runs
    public List<Run> findAll() {
        return runs;
    }

    // Fetch a run by its ID
    public Optional<Run> findById(int id) {
        return runs.stream()
                   .filter(run -> run.id() == id)
                   .findFirst();
    }

    void create(Run run){
        runs.add(run);
    }

    void update(Run run, Integer id){
        Optional<Run> existingRun = findById(id);
        if (existingRun.isPresent()){
            runs.set(runs.indexOf(existingRun.get()), run);
        }
    }

    void delete(Integer id){
        runs.removeIf(run -> run.id() == id);
    }
    // Initialize the repository with sample data
    @PostConstruct
    private void init() {
        runs.add(new Run(1, "Test", LocalDateTime.now(), LocalDateTime.now().plus(1, ChronoUnit.HOURS), 5, Location.INDOOR));
        runs.add(new Run(2, "Test2", LocalDateTime.now(), LocalDateTime.now().plus(2, ChronoUnit.HOURS), 10, Location.OUTDOOR));
    }
}
