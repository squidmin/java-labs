Java 11, officially released in September 2018, introduced several important features and updates that enhanced the language and its ecosystem. Here are some of the notable features:

1. **Local-Variable Syntax for Lambda Parameters (JEP 323)**: This feature allows you to use the `var` keyword when declaring the formal parameters of implicitly typed lambda expressions, making the code cleaner and more consistent.

2. **Dynamic Class-File Constants (JEP 309)**: Java 11 introduced a new kind of constant pool entry, `CONSTANT_Dynamic`, to reduce the cost and disruption of creating new forms of materializable class-file constants. This supports the evolution of languages built on the JVM.

3. **Epsilon: A No-Op Garbage Collector (JEP 318)**: Epsilon is an experimental garbage collector that handles memory allocation but does not actually reclaim memory. It's useful for performance testing and extremely short-lived jobs.

4. **ZGC: A Scalable Low-Latency Garbage Collector (Experimental) (JEP 333)**: The Z Garbage Collector (ZGC) is designed for applications with very large heaps, low latency requirements, and scalable performance characteristics.

5. **HTTP Client (Standard) (JEP 321)**: The new HTTP Client API that was introduced as an incubator feature in Java 9 was standardized in Java 11. This API supports HTTP/2 and WebSocket and aims to replace the legacy `HttpURLConnection` API.

6. **Launch Single-File Source-Code Programs (JEP 330)**: This enhancement allows you to directly run a single-file program that contains source code without compiling it explicitly (`java MyProgram.java`), which is great for quickly testing or running small snippets.

7. **Unicode 10 (JEP 327)**: Java 11 updated the Unicode support to include version 10.0 of the Unicode Standard, adding support for the latest emojis, scripts, and symbol sets.

8. **Remove the Java EE and CORBA Modules (JEP 320)**: With Java 11, several modules that were part of Java EE and CORBA were removed from the standard JDK distribution. This aligns with the modularization efforts introduced in Java 9 and the shift towards lighter Java applications.

9. **Nest-Based Access Control (JEP 181)**: This feature improves the performance of accessing private members by classes that are logically part of the same code entity but separated into different classes, such as nested classes.

10. **Deprecate the Nashorn JavaScript Engine (JEP 335)**: The Nashorn JavaScript engine, introduced in Java 8, was deprecated in Java 11, signaling its eventual removal from future Java versions.

These enhancements and additions make Java 11 a significant release in terms of both performance improvements and modern language features.