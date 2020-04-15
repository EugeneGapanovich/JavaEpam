package com.company.library.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

public class Author {
    private short age;
    private List<Book> books;

    public Author(short age) {
        this.age = age;
        this.books = new ArrayList<>();
    }

    public short getAge() {
        return age;
    }

    public void setAge(short age) {
        this.age = age;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public void addBook(Book book){
        this.books.add(book);
    }

    public void removeBook(Book book){
        this.books.remove(book);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return age == author.age &&
                Objects.equals(books, author.books);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, books);
    }
    
    @Override
    public String toString() {
            StringBuilder str = new StringBuilder();
            str.append("Author{");
            str.append("age='").append(age).append('\'');
            str.append("; ");
            str.append("count of books='").append(books.size());
            str.append('\'');
            str.append('}');
            return str.toString();
    }
}
