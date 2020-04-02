package com.company.library.run;

import com.company.library.entity.Author;
import com.company.library.entity.Book;
import com.company.library.manipulation.BookStream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Author> authors = new ArrayList<>();
        authors.add(new Author((short) 29));
        authors.add(new Author((short) 25));
        authors.add(new Author((short) 46));
        authors.add(new Author((short) 25));
        authors.add(new Author((short) 33));

        List<Book> books = new ArrayList<>();
        books.add(new Book("Lord of the Rings", 1125));
        books.add(new Book("Harry Potter", 3389));
        books.add(new Book("Dead Souls", 400));
        books.add(new Book("On the Western Front without change", 163));
        books.add(new Book("Don Quixote", 451));
        books.add(new Book("Object Oriented Programming in C ++", 923));
        books.add(new Book("Anthology \"Metro\"", 600));


        authors.get(0).addBook(books.get(5));
        authors.get(0).addBook(books.get(0));
        authors.get(1).addBook(books.get(1));
        authors.get(1).addBook(books.get(6));
        authors.get(2).addBook(books.get(3));
        authors.get(2).addBook(books.get(6));
        authors.get(2).addBook(books.get(5));
        authors.get(3).addBook(books.get(2));
        authors.get(3).addBook(books.get(1));
        authors.get(4).addBook(books.get(4));
        authors.get(4).addBook(books.get(6));
        for (int i = 0; i < authors.size(); i++) {
            System.out.println(authors.get(i));
        }

        books.get(0).addAuthor(authors.get(0));
        books.get(1).addAuthor(authors.get(1));
        books.get(1).addAuthor(authors.get(3));
        books.get(2).addAuthor(authors.get(3));
        books.get(3).addAuthor(authors.get(2));
        books.get(4).addAuthor(authors.get(4));
        books.get(5).addAuthor(authors.get(0));
        books.get(5).addAuthor(authors.get(2));
        books.get(6).addAuthor(authors.get(1));
        books.get(6).addAuthor(authors.get(2));
        books.get(6).addAuthor(authors.get(4));
        for (int i = 0; i < books.size(); i++) {
            System.out.println(books.get(i));
        }
        BookStream bStream = new BookStream();
        System.out.println(bStream.isExistMoreThanTwoHundredPages(books));
        System.out.println(bStream.findBooksWithTheMaxNumberOfPages(books));
        System.out.println(bStream.findBooksWithTheMinNumberOfPages(books));
    }
}
