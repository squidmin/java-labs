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

11. **Java Flight Recorder**: Java Flight Recorder (JFR) is a profiling tool built into the JVM. It was commercial and required a license in earlier versions, but starting from Java 11, it is available as an open-source feature. JFP is used for collecting diagnostics and profiling data from a running Java application.

12. **Improved Aarch64 Support**: Enhancements in the ARM architecture support, particularly for AArch64 (ARM64), which means better performance and stability on ARM platforms.

13. **Low-Overhead Heap Profiling**: Introduction of a low-overhead heap profiling framework, part of JEP 331, which provides a way for applications to understand memory usage and potential leaks with minimal performance impact.

14. **New Garbage Collectors**: In addition to the experimental introduction of ZGC, another garbage collector called Shenandoah was integrated as an experimental feature. Shenandoah aims to reduce GC pause times by doing most of the garbage collection work concurrently with the running Java threads.

15. **Unicode 11**: Java 11 updates Unicode support to Unicode 11, which provides new characters, scripts, and emojis over Unicode 10 that was used in Java 10.

16. **Security Enhancements**: Improvements to the security libraries including, but not limited to, enhancements in TLS (Transport Layer Security) to support TLS 1.3, and removal of several deprecated features like the `com.sun.security.enableCRLDP` and `com.sun.security.enableAIAcaIssuers` system properties.

17. **Deprecations and Removals**: Several APIs and tools were deprecated or removed in Java 11. For example, the Java EE modules that were deprecated in Java 9 are now completely removed. Tools like `jhat` (Java Heap Analysis Tool) were also removed.

18. **New System Property to Control JIT Compiler's Use**: A new system property, `jdk.disableLastUasgeTracking`, was introduced to control whether the Just-In-Time (JIT) compiler tracks the last usage of classes and methods.

These enhancements and additions make Java 11 a significant release in terms of both performance improvements and modern language features.