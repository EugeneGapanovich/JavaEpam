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
        System.out.println("*******************");
        System.out.println("Exist more than two hundred pages: ");
        System.out.println(bStream.isExistMoreThanTwoHundredPages(books));

        System.out.println("*******************");
        System.out.println("Find books with the max number of pages: ");
        System.out.println(bStream.findBooksWithTheMaxNumberOfPages(books));

        System.out.println("*******************");
        System.out.println("Find books with the min number of pages: ");
        System.out.println(bStream.findBooksWithTheMinNumberOfPages(books));


        System.out.println("*******************");
        System.out.println("Get books with one author: ");
        System.out.println(bStream.getBooksWithOneAuthor(books));


        System.out.println("*******************");
        System.out.println("Sorted books by title: ");
        System.out.println(bStream.sortBookByTitle(books));

        System.out.println("*******************");
        System.out.println("Sorted books by number of pages: ");
        System.out.println(bStream.sortBookByNumberOfPages(books));

        System.out.println("*******************");
        System.out.println("List of authors: ");
        System.out.println(bStream.getListOfAuthors(books));

        System.out.println("*******************");
        System.out.println("Print list of authors: ");
        bStream.printListOfAuthors(books);

/*        System.out.println("*******************");
        System.out.println("List of distinct authors: ");
        System.out.println(bStream.getListOfDistinctAuthors(books));*/

        System.out.println("*******************");
        System.out.println("Time - sort book by title: ");
        System.out.println(bStream.checkTimeSpeedOfSortBookByNumberOfPages(books));
        System.out.println("Time - sort book by title with parallel: ");
        System.out.println(bStream.checkTimeSpeedOfSortBookByNumberOfPagesWithParallel(books));

        System.out.println("*******************");
        System.out.println("OPTIONAL: ");
        System.out.println(bStream.findBooksWithTheMinNumberOfPagesWithOptional(books));
    }
}
