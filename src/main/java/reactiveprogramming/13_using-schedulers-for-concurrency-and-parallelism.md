# Using Schedulers for Concurrency and Parallelism

Schedulers in Project Reactor provide ways to control the execution context of reactive streams, enabling concurrency and parallelism.

```java
public class Example {
    public static void main(String[] args) {
        Flux<Integer> numbers = Flux.range(1, 10)
            .publishOn(Schedulers.parallel())
            .map(n -> n * n);
        
        numbers.subscribe(System.out::println);
    }
}
```
