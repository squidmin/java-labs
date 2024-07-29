# Error Handling in Reactive Streams

Error handling is an essential aspect of reactive programming.
Project Reactor provides several operators for managing errors.

### OnErrorReturn Operator

```java
public class Example {
    public static void main(String[] args) {
        Flux<Integer> numbers = Flux.just(1, 2, 3, 4, 5)
            .map(n -> {
                if (n == 3) {
                    throw new RuntimeException("Error on 3");
                }
                return n;
            })
            .onErrorReturn(-1);
        
        numbers.subscribe(System.out::println); // Outputs: 1, 2, -1
    }
}
```

## Retry Operator

```java
public class Example {
    public static void main(String[] args) {
        Flux<Integer> numbers = Flux.just(1, 2, 3, 4, 5)
            .map(n -> {
                if (n == 3) {
                    throw new RuntimeException("Error on 3");
                }
                return n;
            })
            .retry(1);
        
        numbers.subscribe(System.out::println);
    }
}
```
