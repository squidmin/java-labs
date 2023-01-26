<details>
<summary>Limitations of Old Date/Time API</summary>

Discussion of the limitations of old date and time API.

The following topics are covered:
- Limitations of the old Date/Time API

Java 8 introduced a new Date and Time API, also known as **JSR-310** under the `java.time` package.

It is a very rich API for working with dates and times. Before we look at the features it provides, we should discuss the limitations of the old API.

### Limitations of the old `Date`/`Time` API

Here are the limitations of the old date and time API:
1. The old date class is not Thread Safe. Unlike String or Integer class, it is not immutable. Any thread can get a reference to the Date object and modify its value.
2. Its month numbering is from 0 to 11. This is very confusing and has resulted in many errors.
3. Prior to JDK 8, Java uses String to represent TimeZone. If we need to get the timezone for Hong Kong, then below is the code:

```
TimeZone zone = TimeZone.getInstance(“Asia/Hong_Kong”);
```

There are chances that we might mistakenly write HongKong or make some other spelling errors. There is no check for this in the old API.

4. A `Date` instance represents an instant in time, not a date. This means that the date in the old API will mean both date and time. If we need only time without date then that is not possible.

These were the main limitations that drove the Java developers to introduce a completely new Date/Time API.

---

The next section discusses the newly added `LocalDate` class in the `Date` API.

</details>


<details>
<summary>LocalDate</summary>



</details>