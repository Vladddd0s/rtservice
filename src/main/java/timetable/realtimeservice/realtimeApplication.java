package timetable.realtimeservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication(scanBasePackages = {"timetable.realtimeservice"})
public class realtimeApplication {
    public static void main(String[] args) {
        SpringApplication.run(realtimeApplication.class, args);
    }
}
