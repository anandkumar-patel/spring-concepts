package reactive.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

@RestController
public class ReactiveController {

    // Simulating a database call that returns a single item
    @GetMapping("/mono/{id}")
    public Mono<String> getSingleValue(@PathVariable String id) {
        // Simulating data fetching (asynchronously)
        return Mono.just("Data for ID: " + id).delayElement(Duration.ofSeconds(1));
    }

    // Simulating a database call that returns a list of items (a Flux)
    @GetMapping("/flux")
    public Flux<String> getMultipleValues() {
        List<String> data = Arrays.asList("Item 1", "Item 2", "Item 3", "Item 4");

        // Simulating data fetching with some delay for each item
        return Flux.fromIterable(data)
                .delayElements(Duration.ofMillis(500));
    }

    // Stream of numbers that keeps emitting data every second
    @GetMapping("/numbers")
    public Flux<Long> getNumberStream() {
        // Generating a stream of numbers that emit every second
        return Flux.interval(Duration.ofSeconds(1)).take(10); // Emits 0,1,2,...,9
    }
}
