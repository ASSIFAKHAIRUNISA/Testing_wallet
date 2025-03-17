package org.example;

public class Book {
    String title;
    String isbn;
    String author;

    public Book(String isbn, String title, String author){
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }
}
