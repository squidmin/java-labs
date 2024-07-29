# `jakarta.servlet.FilterChain` in Java 21

## Overview

`jakarta.servlet.FilterChain` is an interface in the Jakarta Servlet API that provides a mechanism for invoking the next filter in a chain of filters or the ultimate resource (e.g., a servlet or static content) at the end of the chain.
Filters are designed to perform filtering tasks on requests to resources or on responses from resources.
The `FilterChain` interface plays a crucial role in passing the request and response objects through the chain.

## Key Concepts

### Definition

A filter chain represents a sequence of filters that are executed in a specific order.
The `FilterChain` interface is used to invoke the next filter or resource in the chain.

### Main Method

The `jakarta.servlet.FilterChain` interface defines a single method:

- `void doFilter(ServletRequest request, ServletResponse response) throws IOException, ServletException`: This method is used to pass the request and response to the next entity in the chain.
  If the current filter is the last in the chain, calling `doFilter` will cause the resource at the end of the chain to be invoked.

## Example Implementation

Here's an example demonstrating how `FilterChain` is used within a custom filter:

```java
package com.example;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

@WebFilter("/*")
public class LoggingFilter implements Filter {
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Initialization code, e.g., reading configuration parameters
        System.out.println("LoggingFilter initialized");
    }
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // Pre-processing: Logging request information
        System.out.println("Request received at: " + System.currentTimeMillis());
        
        // Passing the request and response to the next entity in the chain
        chain.doFilter(request, response);
        
        // Post-processing: Logging response information
        System.out.println("Response sent at: " + System.currentTimeMillis());
    }
    
    @Override
    public void destroy() {
        // Cleanup code
        System.out.println("LoggingFilter destroyed");
    }
    
}
```

In this example:

- The `doFilter` method logs the request before passing it to the next filter or servlet in the chain using `chain.doFilter(request, response)`.
- After the next entity processes the request, the response is logged.

## Configuration

### XML-based Configuration

You can configure the filter in the `web.xml` file:

```xml
<filter>
    <filter-name>LoggingFilter</filter-name>
    <filter-class>com.example.LoggingFilter</filter-class>
</filter>
<filter-mapping>
    <filter-name>LoggingFilter</filter-name>
    <url-pattern>/*</url-pattern>
</filter-mapping>
```

### Annotation-based Configuration

```java
package com.example;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

@WebFilter("/*")
public class LoggingFilter implements Filter {
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("LoggingFilter initialized");
    }
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("Request received at: " + System.currentTimeMillis());
        chain.doFilter(request, response);
        System.out.println("Response sent at: " + System.currentTimeMillis());
    }
    
    @Override
    public void destroy() {
        System.out.println("LoggingFilter destroyed");
    }
    
}
```

## Use Cases

- **Logging and Auditing**: Recording details about requests and responses for monitoring and analysis.
- **Authentication and Authorization**: Checking user credentials and permissions before allowing access to resources.
- **Data Compression**: Compressing response data to improve performance over the network.
- **Input Validation and Sanitization**: Ensuring that incoming request data meets expected formats and security standards.

## Conclusion

`jakarta.servlet.FilterChain` is an essential interface in the Jakarta Servlet API that allows filters to pass requests and responses along a chain of filters and eventually to the target resource.
By understanding and effectively using `FilterChain`, you can enhance the functionality, security, and performance of your web applications.
