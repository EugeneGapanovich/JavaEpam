package com.company.library.manipulation;

import com.company.library.entity.Book;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class BookStream {

    public boolean isExistMoreThanTwoHundredPages(List<Book> books){
        return books.stream().anyMatch(x -> x.getNumberOfPages() > 200);
    }

    public Book findBooksWithTheMinNumberOfPages(List<Book> books){
        Book minBook = books.stream().min(Book::compareByPages).get();
        return minBook;
    }

    public Book findBooksWithTheMaxNumberOfPages(List<Book> books){
        Book maxBook = books.stream().max(Book::compareByPages).get();
        return maxBook;
    }
}
