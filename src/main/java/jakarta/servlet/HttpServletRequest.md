# `HttpServletRequest` in Java 21

## Overview

`jakarta.servlet.http.HttpServletRequest` is an interface in the Jakarta Servlet API that extends `jakarta.servlet.ServletRequest` and provides additional methods to handle HTTP-specific request information.
This interface is used to retrieve various attributes, parameters, and cookies from the client's HTTP request.

## Key Concepts

### Definition

The `HttpServletRequest` interface defines an object that contains the client request information passed to a servlet.
It provides methods to access HTTP-specific information such as request headers, cookies, and query parameters.

### Main Methods

The `HttpServletRequest` interface defines several methods to interact with HTTP requests:

- **HTTP Method Information:**
  - `String getMethod()`: Returns the HTTP method (e.g., GET, POST) with which the request was made.

- **Request URI Information:**
  - `String getRequestURI()`: Returns the part of this request's URL from the protocol name up to the query string.
  - `StringBuffer getRequestURL()`: Reconstructs the URL the client used to make the request.
  - `String getContextPath()`: Returns the portion of the request URI that indicates the context of the request.
  - `String getServletPath()`: Returns the part of this request's URL that calls the servlet.

- **Parameter Methods:**
  - `String getParameter(String name)`: Returns the value of a request parameter as a `String`, or `null` if the parameter does not exist.
  - `Map<String, String[]> getParameterMap()`: Returns a `Map` of parameter names and their values.
  - `Enumeration<String> getParameterNames()`: Returns an enumeration of all parameter names.
  - `String[] getParameterValues(String name)`: Returns an array of `String` objects containing all the parameter values associated with the given parameter name.

- **Header Methods:**
  - `String getHeader(String name)`: Returns the value of the specified request header as a `String`.
  - `Enumeration<String> getHeaderNames()`: Returns an enumeration of all the header names this request contains.
  - `Enumeration<String> getHeaders(String name)`: Returns all the values of the specified request header as an enumeration of `String` objects.
  - `int getIntHeader(String name)`: Returns the value of the specified request header as a `long` representing the date.
  - `long getDateHeader(String name)`: Returns the value of the specified request header as a `long` representing the date.

- **Cookie Methods:**
  - `Cookie[] getCookies()`: Returns an array of `Cookie` objects that the client sent with this request.

- **Session Methods:**
  - `HttpSession getSession()`: Returns the current session associated with this request, or creates a new session if none exists.
  - `HttpSession getSession(boolean create)`: Returns the current session associated with this request, or if these is no current session and `create` is true,returns a new session.

- **Attribute Methods:**
  - `Object getAttribute(String name)`: Returns the value of the named attribute as an `Object`, or `null` if the attribute does not exist.
  - `Enumeration<String> getAttributeNames()`: Returns an enumeration of all attribute names.
  - `void setAttribute(String name, Object o)`: Sets the attribute with the given name to the specified value.
  - `void removeAttribute(String name)`: Removes the attribute with the given name.

- **Locale Methods:**
  - `Locale getLocale()`: Returns the preferred `Locale` that the client will accept content in.
  - `Enumeration<Locale> getLocales()`: Returns an enumeration of `Locale` objects indicating the preferred order of locales.

- **Request Information:**
  - `String getQueryString()`: Returns the query string that is contained in the request URL after the path.
  - `String getRemoteUser()`: Returns the login of the user making this request, if the user has been authenticated.
  - `Principal getUserPrincipal()`: Returns a `java.security.Principal` object containing the name of the current authenticated user.
  - `String getRequestedSessionId()`: Returns the session ID specified by the client.
  - `boolean isRequestedSessionIdValid()`: Checks whether the requested session ID is valid.
  - `boolean isUserInRole(String role)`: Returns a boolean indicating whether the authenticated user is included in the specified logical "role".

## Lifecycle

`HttpServletRequest` is created by the servlet container for each HTTP client request nad passed to the servlet's `service` method or the appropriate `doGet`, `doPost`, `doPut`, etc., method.
The servlet uses the `HttpServletRequest` object to retrieve information about the HTTP request.

## Example Usage

Here's an example of how to use the `HttpServletRequest` interface in a servlet;

```java
package com.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet("/example")
public class ExampleServlet extends HttpServlet {
    
}
```


