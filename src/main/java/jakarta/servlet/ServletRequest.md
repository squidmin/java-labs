# `ServletRequest` in Java 21

## Overview

`jakarta.servlet.ServletRequest` is an interface in the Jakarta Servlet API that provides request information for servlets.
This interface is used to retrieve various parameters, attributes, and input streams from the client request.

## Key Concepts

The `ServletRequest` interface defines an object that contains the client request information passed to a servlet.
It provides methods to access various attributes of the request such as parameters, headers, and input streams.

### Main Methods

The `ServletRequest` interface defines several methods to interact with client requests:

- **Parameter Methods:**
  - `String getParameter(String name)`: Returns the value of a request parameter as a `String`, or `null` if the parameter does not exist.
  - `Map<String, String[]> getParameterMap()`: Returns a `Map` of parameter names and their values.
  - `Enumeration<String> getParameterNames()`: Returns an enumeration of all parameter names.
  - `String[] getParameterValues(String name)`: Returns an array of `String` objects containing all the parameter values associated with the given parameter name.
- **Attribute Methods:**
  - `Object getAttribute(String name)`: Returns the value of the named attribute as an `Object`, or `null` if the attribute does not exist.
  - `Enumeration<String> getAttributeNames()`: Returns an enumeration of all attribute names.
  - `void setAttribute(String name, Object o)`: Sets the attribute with the given name to the specified value.
  - `void removeAttribute(String name)`: Removes the attribute with the given name.
- **Content Methods:**
  - `String getContentType()`: Returns the MIME type of the body of the request.
  - `int getContentLength()`: Returns the length of the request body in bytes, or `-1` if the length is not known.
  - `long getContentLengthLong()`: Returns the length of the request body as a `long`, or `-1` if the length is not known.
  - `ServletInputStream getInputStream()`: Retrieves the body of the request as binary data.
  - `BufferedReader getReader()`: Retrieves the body of the request as character data.
- **Locale Methods:**
  - `Locale getLocale()`: Returns the preferred `Locale` that the client will accept content in.
  - `Enumeration<Locale> getLocales()`: Returns an enumeration of `Locale` objects indicating the preferred order of locales.
- **Miscellaneous Methods:**
  - `String getCharacterEncoding()`: Returns the name of the character encoding used in the body of this request.
  - `void setCharacterEncoding(String env)`: Overrides the character encoding used in the body of this request.
  - `String getProtocol()`: Returns the name and version of the protocol the request uses.
  - `String getScheme()`: Returns the scheme used to make this request (e.g., `http`, `https`).
  - `String getServerName()`: Returns the host name of the server to which the request was sent.
  - `int getServerPort()`: Returns the port number to which the request was sent.
  - `String getRemoteAddr()`: Returns the Internet Protocol (IP) address of the client or the last proxy that sent the request.
  - `String getRemoteHost()`: Returns the fully qualified name of the client or the last proxy that sent the request.
  - `String getLocalName()`: Returns the host name of the Internet Protocol (IP) interface on which the request was received.
  - `int getLocalPort()`: Returns the port number on which the request was received.

### Lifecycle

`ServletRequest` is created by the servlet container for each client request and passed to the servlet's `service` method or the appropriate `doGet`, `doPost`, `doPut`, etc., method.
The servlet uses the `ServletRequest` object to retrieve information about the client request.

## Example Usage

Here's an example of how to use the `ServletRequest` interface in a servlet:

```java
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/example")
public class ExampleServlet extends HttpServlet {
    
    @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve a request parameter
      String name = request.getParameter("name");
      
      // Set the response content type
      response.setContentType("text/html");
      
      // Get the PrintWriter to write the response
      PrintWriter out = response.getWriter();
      
      // Write the response
      out.println("<html><body>");
      out.println("<h1>Hello, " + name + "</h1>");
      out.println("</body><html>");
    }
    
}
```

In this example:

- The `doGet` method retrieves the value of a request parameter named `name`.
- The servlet responds with an HTML page that greets the user by name.

## Use Cases

- **Parameter Handling**: Accessing and processing query parameters sent with the client request.
- **Attribute Management**: Storing and retrieving attributes for communication between components in a request.
- **Content Retrieval**: Reading the body of the request, useful for handling for submissions or file uploads.
- **Locale Management**: Determining the client's preferred locale for internationalization purposes.

## Conclusion

`jakarta.servlet.ServletRequest` is a fundamental interface in the Jakarta Servlet API that provides a way to retrieve information about client requests.
By leveraging the methods provided by `ServletRequest`, developers can effectively handle and process incoming requests in their web applications.
