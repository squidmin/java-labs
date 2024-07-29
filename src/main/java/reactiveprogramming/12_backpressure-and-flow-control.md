# Backpressure and Flow Control

Backpressure is the ability of a consumer to signal the producer about the rate at which it can handle data.
Project Reactor supports backpressure, allowing consumers to request a specific number of items.

```java
public class Example {
    public static void main(String[] args) {
        Flux<Integer> numbers = Flux.range(1, 10);
        numbers.subscribe(new BaseSubscriber<Integer>() {
            @Override
            protected void hookOnSubscribe(Subscription subscription) {
                request(2); // Requesting 2 items initially
            }
            
            @Override
            protected void hookOnNext(Integer value) {
                System.out.println("Received: " + value);
                request(1); // Requesting 1 more item after processing each item
            }
        });
    }
}
```
