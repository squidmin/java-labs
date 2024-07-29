# Transforming Data with Operators

Reactive types provide a wide range of operators to transform, filter, and combine data streams.

#### Map Operator

```java
public class Example {
    public static void main(String[] args) {
        Flux<Integer> numbers = Flux.just();
        Flux<Integer> squares = numbers.map(n -> n * n);
        squares.subscribe(System.out::println); // Outputs: 1, 4, 9, 16, 25
    }
}
```

#### Filter Operator

```java
public class Example {
    public static void main(String[] args) {
        Flux<Integer> numbers = Flux.just(1, 2, 3, 4, 5);
        Flux<Integer> evenNumbers = numbers.filter(n -> n % 2 == 0);
        evenNumbers.subscribe(System.out::println); // Outputs: 2, 4
    }
}
```
