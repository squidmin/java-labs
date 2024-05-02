# JShell

JShell, introduced in Java 9, is an interactive tool that allows for the rapid testing and debugging of Java code snippets without the need for a full development environment.
It's a Read-Eval-Print Loop (REPL), meaning it reads user input, evaluates it, prints the result, and loops back to read again.
This tool is invaluable for experimenting with Java's features, learning the language, and testing code snippets quickly.
Here's a detailed guide on how to use JShell.

## Getting Started with JShell

Ensure you have JDK 9 or later installed on your system.
You can check your Java version by running `java -version` in your terminal or command prompt.
If you need to install or update Java, visit the official Oracle website or adopt a distribution like OpenJDK.

## Launching JShell

To start JShell, open your terminal (on macOS or Linux) or command prompt (on Windows) and type `jshell`, then press **Enter**.
You should see a welcome message along with a prompt where you can start typing Java commands:

```shell
|  Welcome to JShell -- Version X
|  For an introduction type: /help intro

jshell>
```

## Basic Operations in JShell

- **Executing Expressions**: You can type any Java expression and press **Enter** to execute it.
  ```shell
  jshell> 2 + 2
  $1 ==> 4
  ```
- **Declaring Variables**: Just like in a regular Java program, you can declare variable.
  ```shell
  jshell> int a = 5
  a ==> 5
  ```
- **Defining Methods**: You can define methods directly in the JShell prompt:
  ```shell
  jshell> int add(int x, int y) { return x + y; }
  |  created method add(int,int)
  ```
  And then call this method:
  ```shell
  jshell> add(5, 3)
  $2 ==> 8
  ```
- **Using Classes**: You can also define classes and use them:
  ```shell
  jshell> class Greeter {
   ...>     String greet(String name) {
   ...>         return "Hello, " + name;
   ...>     }
   ...> }
  |  created class Greeter
  ```
  And then instantiate and use the class:
  ```shell
  jshell> Greeter greeter = new Greeter()
  greeter ==> Greeter@4b67cf4d

  jshell> greeter.greet("Java")
  $3 ==> "Hello, Java"
  ```
  
## Useful Commands

JShell includes several commands that begin with a slash (/) to manage your session:

- `/list`: Lists all snippets you've entered.
- `/methods`: Shows all methods you've defined.
- `/vars`: Lists all variables you've declared.
- `/classes`: Lists all classes you've defined.
- `/imports`: Lists all imported packages.
- `/exit`: Exits JShell.
- `/help`: Shows a list of all available commands.
- `/reset`: Clears all snippets and resets the session.
- `/save`: Saves the current session to a file.
- `/open`: Opens a file and executes its content.
- `/edit`: Edits a snippet.
- `/drop`: Removes a snippet.
- `/history`: Shows the command history.
- `/set`: Configures JShell options.
- `/env`: Shows the current environment settings.
- `/reload`: Reloads the current session.

## Exiting JShell

To exit JShell, type `/exit` and press **Enter**, or simply press **Ctrl+D** (on macOS and Linux) or **Ctrl+Z** followed by **Enter** (on Windows).

## Tips for Using JShell

- JShell is great for experimenting with Java's APIs and language features.
- Use it to quickly test your understanding of Java syntax and operations.
- It's a helpful tool for educators and learners in interactive Java learning sessions.

By using JShell, you can significantly speed up the process of testing and debugging small snippets of Java code, making it easier to learn and experiment with the language.
