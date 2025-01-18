package reactive.controller;

import java.time.Duration;
import java.util.Random;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;

@RestController
public class PatientVitalsController {
	
	// Simulating real-time patient vitals data streaming
    @GetMapping("/patient-vitals")
    public Flux<String> streamPatientVitals() {
        Random random = new Random();

        // Emit patient vitals every 1 second
        return Flux.interval(Duration.ofSeconds(1))
                .map(interval -> {
                    // Simulating random vitals for demonstration
                    int heartRate = 60 + random.nextInt(40);   // 60-100 bpm
                    int bloodPressure = 110 + random.nextInt(30); // 110-140 mmHg
                    int oxygenLevel = 90 + random.nextInt(10);   // 90-100%

                    return String.format("Heart Rate: %d bpm, Blood Pressure: %d mmHg, Oxygen Level: %d%%", 
                            heartRate, bloodPressure, oxygenLevel);
                });
    }
}
