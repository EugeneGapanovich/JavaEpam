package com.company.library.manipulation;

import com.company.library.entity.Author;
import com.company.library.entity.Book;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class BookStream {

    public boolean isExistMoreThanTwoHundredPages(List<Book> books){
        return books.stream().anyMatch(book -> book.getNumberOfPages() > 200);
    }

    public List findBooksWithTheMinNumberOfPages(List<Book> books){
        Book minBook = books.stream().min(Book::compareByPages).get();
        int minCountPages = minBook.getNumberOfPages();
        List<Book> booksMin = books.stream().filter(book -> book.getNumberOfPages() == minCountPages).collect(Collectors.toList());
        return booksMin;
    }

    public List findBooksWithTheMaxNumberOfPages(List<Book> books){
        Book maxBook = books.stream().max(Book::compareByPages).get();
        int maxCountPages = maxBook.getNumberOfPages();
        List<Book> booksMax= books.stream().filter(book -> book.getNumberOfPages() == maxCountPages)
                .collect(Collectors.toList());
        return booksMax;
    }

    public List getBooksWithOneAuthor(List<Book> books){
        List<Book> booksWithOneAuthor = books.stream().filter(book -> book.getAuthors().size() == 1)
                .peek(book -> System.out.println("Filtered value: " + book))
                .collect(Collectors.toList());
        return booksWithOneAuthor;
    }

    public List sortBookByTitle(List<Book> books){
        List<Book> bookSort = books.stream().sorted(Comparator.comparing(Book::getTitle))
                .peek(book -> System.out.println("Filtered value: " + book))
                .collect(Collectors.toList());
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

   /* public List getListOfDistinctAuthors(List<Book> books){
        List<Author> listOfAuthors = new ArrayList<>();
        books.stream().forEach(book -> listOfAuthors.addAll(book.getAuthors()));
        return listOfAuthors;
    }*/

    public List checkTimeSpeedOfSortBookByNumberOfPages(List<Book> books){
        long nano_startTime = System.nanoTime();
        List<Book> bookSort = books.stream().sorted(Comparator.comparing(Book::getTitle))
                .collect(Collectors.toList());
        long nano_endTime = System.nanoTime();
        System.out.println("Time taken in nano seconds: "
                + (nano_endTime - nano_startTime));
        return bookSort;
    }

    public List checkTimeSpeedOfSortBookByNumberOfPagesWithParallel(List<Book> books){
        long nano_startTime = System.nanoTime();
        List<Book> bookSort = books.stream().parallel().sorted(Comparator.comparing(Book::getTitle))
                .peek(book -> System.out.println("Filtered value: " + book))
                .collect(Collectors.toList());
        long nano_endTime = System.nanoTime();
        System.out.println("Time taken in nano seconds: "
                + (nano_endTime - nano_startTime));
        return bookSort;
    }

    public List findBooksWithTheMinNumberOfPagesWithOptional(List<Book> books){
        Optional<Book> minBook = Optional.ofNullable(Optional.of(books.stream().min(Book::compareByPages).get()).orElseThrow(NullPointerException::new));
        int minCountPages = minBook.get().getNumberOfPages();
        List<Book> booksMin = books.stream().filter(book -> book.getNumberOfPages() == minCountPages).collect(Collectors.toList());
        return booksMin;
    }
}
