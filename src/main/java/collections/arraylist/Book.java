package collections.arraylist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Book implements Comparable<Book> {

    private final String title;
    private final String author;
    private final int yearPublished;

    public Book(String title, String author, int yearPublished) {
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
    }

    @Override
    public int compareTo(Book book) {
        return this.yearPublished == book.yearPublished ?
            this.title.compareTo(book.title) : this.yearPublished - book.yearPublished;
    }

    public static void main(String[] args) {
        List<Book> books = new ArrayList<>(List.of(
            new Book("Some book", "Jeff", 1789),
            new Book("Another book", "Geoff", 1999),
            new Book("Old book", "Sillybird", 1607),
            new Book("Another old book", "Lorb of Dorkness", 1607)
        ));
        Collections.sort(books);
        books.forEach(book -> System.out.println("Title: " + book.title + "; Author: " + book.author + "; Year published: " + book.yearPublished));
    }

}
