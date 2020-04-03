package com.company.library.manipulation;

import com.company.library.entity.Author;
import com.company.library.entity.Book;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BookStream {

    public boolean isExistMoreThanTwoHundredPages(List<Book> books){
        return books.stream().anyMatch(book -> book.getNumberOfPages() > 200);
    }

    public Book findBookWithTheMinNumberOfPages(List<Book> books){
        Book minBook = books.stream().min(Book::compareByPages).get();
        return minBook;
    }

    public Book findBookWithTheMaxNumberOfPages(List<Book> books){
        Book maxBook = books.stream().max(Book::compareByPages).get();
        return maxBook;
    }

    public List getBooksWithOneAuthor(List<Book> books){
        List<Book> booksWithOneAuthor = books.stream().filter(book -> book.getAuthors().size() == 1).collect(Collectors.toList());
        return booksWithOneAuthor;
    }

    public List sortBookByTitle(List<Book> books){
        List<Book> bookSort = books.stream().sorted(Comparator.comparing(Book::getTitle)).collect(Collectors.toList());
        return bookSort;
    }

    public List sortBookByNumberOfPages(List<Book> books){
        List<Book> bookSort = books.stream().sorted(Comparator.comparing(Book::getNumberOfPages)).collect(Collectors.toList());
        return bookSort;
    }

    public List getListOfAuthors(List<Book> books){
        List<Author> listOfAuthors = new ArrayList<>();
        books.stream().forEach(book -> listOfAuthors.addAll(book.getAuthors()));
        return listOfAuthors;
    }

    public void printListOfAuthors(List<Book> books){
        List<Author> listOfAuthors = new ArrayList<>();
        books.stream().forEach(book -> listOfAuthors.addAll(book.getAuthors()));
        System.out.println(listOfAuthors);
    }

    public List getListOfDistinctAuthors(List<Book> books){
        List<Author> listOfAuthors = new ArrayList<>();
        books.stream().forEach(book -> listOfAuthors.addAll(book.getAuthors()));
        return listOfAuthors;
    }
}
