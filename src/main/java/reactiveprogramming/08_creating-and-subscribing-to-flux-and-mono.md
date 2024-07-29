# Creating and Subscribing to Flux and Mono

#### Flux Example

```java
import reactor.core.publisher.Flux;

public class FluxExample {
    public static void main(String[] args) {
        Flux<String> flux = Flux.just("Hello", "Reactive", "World")
                                .map(String::toUpperCase)
                                .filter(s -> s.startsWith("R"));

        flux.subscribe(System.out::println); // Outputs: REACTIVE
    }
}
```

#### Mono Example

```java
import reactor.core.publisher.Mono;

public class MonoExample {
    public static void main(String[] args) {
        Mono<String> mono = Mono.just("Hello, Mono")
                                .map(String::toUpperCase);

        mono.subscribe(System.out::println); // Outputs: HELLO, MONO
    }
}
```
