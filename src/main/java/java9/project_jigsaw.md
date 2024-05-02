# Project Jigsaw

Project Jigsaw, introduced in Java 9, brought a long-awaited modular system to the Java platform.
Its primary goals were to make the Java Standard Edition scalable to smaller devices, improve the security and maintainability of Java applications, and enhance application performance.
Before modules, Java applications, including small programs, had to carry the entire Java Runtime Environment (JRE), which includes all of its libraries, regardless of which parts were actually needed by the application.
This not only increased the size of deployments but also introduced security risks and made updates and maintenance more cumbersome.

## Key Concepts of the Java Module System

- **Modules**: A module is a named, self-describing collection of code and data. Its code is organized as a set of packages containing types (Java classes, interfaces, enums, and annotations), and its data includes resources and other kinds of static information. Each module has a module descriptor that defines its identity, its dependencies on other modules, what it makes available to other modules, and what it keeps hidden from them.
- **Module Descriptor**: Each module contains a module descriptor, a file named `module-info.java` at the module's root. This file specifies the module's name, what it requires from other modules, and what it exports.
- **Readability**: A module explicitly declares which other modules it depends on. This creates a readability graph that the JVM uses to ensure all necessary modules are available at runtime.
- **Accessibility**: By default, a module only allows access to its `public` types if it explicitly exports the package containing those types. This encapsulation helps maintain a clean separation of concerns.

## Benefits of the Module System

1. **Reliable Configuration**: By declaring dependencies explicitly, the module system can ensure that all required modules are present at compile time and runtime, reducing runtime errors due to missing components.
2. **Strong Encapsulation**: Modules can hide their internal implementation details from other modules, exposing only those parts that are meant to be used by others. This reduces the risk of inadvertent use of internal APIs and improves security and maintainability.
3. **Scalable Java Applications**: Modular applications can be assembled with only the necessary modules, reducing the size of the runtime environment. This is particularly beneficial for small devices and cloud-native applications where resources are limited.
4. **Improved Performance**: The module system allows the JVM to optimize startup time and memory footprint by only loading the necessary modules.

## Example: Creating a Simple Modular Application

Suppose we have a simple application with two modules:
- `com.example.hello` (which depends on `com.example.greetings`)
- `com.example.greetings`

Module `com.example.greetings`:

1. **Module Descriptor** (`module-info.java`):

   ```java
   module com.example.greetings {
       exports com.example.greetings;
   }
   ```
   
2. **A class that provides a greeting** (`Greeting.java`):

   ```java
   package com.example.greetings;
   
   public class Greeting {
       public static String getGreeting() {
           return "Hello";
       }
   }
   ```
   
Module `com.example.hello`:

1. **Module Descriptor** (`module-info.java`):

   ```java
   module com.example.hello {
       requires com.example.greetings;
   }
   ```

2. **A main class that uses** `Greeting` from `com.example.greetings` (`Main.java`):

   ```java
   package com.example.hello;
   
   import com.example.greetings.Greeting;
   
   public class Main {
       public static void main(String[] args) {
           System.out.println(Greeting.getGreeting());
       }
   }
   ```
   
## Building and Running the Modular Application

1. **Compile the modules**:

   ```bash
   javac -d mods/com.example.greetings com.example.greetings/module-info.java com.example.greetings/com/example/greetings/Greeting.java
   javac --module-path mods -d mods/com.example.hello com.example.hello/module-info.java com.example.hello/com/example/hello/Main.java
   ```
   
2. **Run the application**:

   ```bash
   java --module-path mods -m com.example.hello/com.example.hello.Main
   ```
   
This basic example illustrates how to define modules, declare dependencies, and encapsulate module internals.
The module system is a powerful feature that supports the development of large-scale, maintainable, and secure Java applications.
