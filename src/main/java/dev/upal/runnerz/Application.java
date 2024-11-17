package dev.upal.runnerz;

import java.lang.reflect.AccessFlag.Location;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import dev.upal.runnerz.run.Run;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	CommandLineRunner runner() {
		return args -> {
			Run run = new Run(1, "Test", LocalDateTime.now(), LocalDateTime.now().plus(1, ChronoUnit.HOURS), 5, dev.upal.runnerz.run.Location.INDOOR);
			System.out.println(run);
	};

}
}
