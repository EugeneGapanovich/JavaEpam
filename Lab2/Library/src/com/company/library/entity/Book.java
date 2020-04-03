package com.company.library.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Book {
    private String title;
    private List<Author> authors;
    private Integer numberOfPages;

    public Book(String title, Integer numberOfPages) {
        this.title = title;
        this.numberOfPages = numberOfPages;
        this.authors = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public Integer getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(Integer numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public void addAuthor(Author author){
        this.authors.add(author);
    }

    public void removeAuthor(Author author){
        this.authors.remove(author);
    }

    public static int compareByPages (Book p1, Book p2){
        if(p1.getNumberOfPages() > p2.getNumberOfPages())
            return 1;
        return -1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(title, book.title) &&
                Objects.equals(authors, book.authors) &&
                Objects.equals(numberOfPages, book.numberOfPages);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, authors, numberOfPages);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Book{");
        str.append("title='").append(title).append('\'');
        str.append("; ");
        str.append("count of pages='").append(numberOfPages).append('\'');
        str.append("; ");
        str.append("count of authors='").append(authors.size());
        str.append('\'');
        str.append('}');
        return str.toString();
    }
}
