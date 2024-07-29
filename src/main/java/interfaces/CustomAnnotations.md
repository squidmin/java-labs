# Custom Annotations

## Overview

Annotations in Java provide a powerful mechanism for adding metadata to code.
Custom annotations can be used to define additional behavior or information that can be processed by tools, frameworks, or at runtime.
In Java, custom annotations are defined using the `@interface` syntax.

## Key Concepts

### Definition

A custom annotation in Java is defined using the `@interface` keyword.
Annotations can have elements, which are essentially methods without a body.
These elements can have default values.

### Elements of Annotations

- **Annotation Type**: Defined using `@interface`.
- **Elements**: Methods without a body. These methods can specify default values.
- **Retention Policy**: Specifies how long annotations are retained (e.g., source, class or runtime).
- **Target**: Specifies the kinds of program elements to which an annotation type is applicable (e.g., method, field, type).
- **Documented**: Indicates that the annotation should be included in the JavaDoc.
- **Inherited**: Indicates that an annotation type is automatically inherited.

### Retention Policies

- **SOURCE**: Annotations are retained only in the source code and are discarded during compilation.
- **CLASS**: Annotations are retained in the class file but are not available at runtime.
- **RUNTIME**: Annotations are retained in the class file and are available at runtime via reflection.

### Targets

- **ElementType.ANNOTATION_TYPE**: Indicates that the declared type itself is an annotation type.
- **ElementType.CONSTRUCTOR**: Indicates that the declared type is applicable to constructors.
- **ElementType.FIELD**: Indicates that the declared type is applicable to fields.
- **ElementType.LOCAL_VARIABLE**: Indicates that the declared type is applicable to local variables.
- **ElementType.METHOD**: Indicates that the declared type is applicable to methods
- **ElementType.PACKAGE**: Indicates that the declared type is applicable to packages.
- **ElementType.PARAMETER**: Indicates that the declared type is applicable to parameters.
- **ElementType.TYPE**: Indicates that the declared type is applicable to any element of a class.

## Example: Creating a Custom Annotation

Here's an example of how to create and use a custom annotation in Java 21.

### Step 1: Define the Custom Annotation

```java
package com.example.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface MyCustomAnnotation {
    String value() default "Default value";
    int number() default 42;
}
```

### Step 2: Use the Custom Annotation

```java
package com.example;

import com.example.annotations.MyCustomAnnotation;

public class AnnotationExample {
    
    @MyCustomAnnotation(value = "Hello", number = 100)
    public void myAnnotatedMethod() {
        System.out.println("This method is annotated with MyCustomAnnotation");
    }
    
    public static void main(String[] args) {
        AnnotationExample example = new AnnotationExample();
        
        // Process the annotation
        if (example.getClass().getDeclaredMethods()[0].isAnnotationPresent(MyCustomAnnotation.class)) {
            MyCustomAnnotation annotation = example.getClass().getDeclaredMethods()[0].getAnnotation(MyCustomAnnotation.class);
            System.out.println("Value: " + annotation.value());
            System.out.println("Number: " + annotation.number());
        }
    }
    
}
```

### Step 3: Processing the Custom Annotation

In the `main` method of `AnnotationExample`, we use reflection to check if the method `myAnnotatedMethod` is annotated with `MyCustomAnnotation` and then retrieve the values of its elements.

## Additional Annotation Features

### Default Values

Elements in an annotation can have default values, which are used if no value is specified when the annotation is applied.

```java
public @interface MyCustomAnnotation {
    String value() default "Default value";
    int number() default 42;
}
```

### Single-Element Annotations

If an annotation has a single element named `value`, it can be used without specifying the element name.

```java
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface SingleValueAnnotation {
    String value();
}
```

Usage:

```java
@SingleValueAnnotation("Only Value")
public void singleValueMethod() {
    // ...
}
```

### Meta-Annotations

Meta-annotations are annotations that apply to other annotations.
Common meta-annotations include:

- `@Retention`: Specifies how long annotations are retained.
- `@Target`: Specifies the kinds of program elements to which an annotation type is applicable.
- `@Documented`: Indicates that the annotation should be included in the JavaDoc.
- `@Inherited`: Indicates that an annotation type is automatically inherited.

## Conclusion

Creating custom annotations in Java 21 provides a flexible way to add metadata to your code.
By defining annotations with `@interface`, specifying retention policies and targets, and processing annotations at runtime using reflection, developers can create powerful and reusable components that enhance the behavior and documentation of their applications.
