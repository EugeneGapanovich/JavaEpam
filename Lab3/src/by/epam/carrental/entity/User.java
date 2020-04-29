package by.epam.carrental.entity;

import by.epam.carrental.exception.UserException;
import by.epam.carrental.validator.ValidPhone;

import java.util.Objects;

public abstract class User extends Entity{
    private String firstName;
    private String lastName;
    private long id;

    public User() {
    }

    public User(String firstName, String lastName, long id){
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                Objects.equals(firstName, user.firstName) &&
                Objects.equals(lastName, user.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, id);
    }

    @Override
    public String toString() {
        return "User{" +
                "first name='" + firstName + '\'' +
                ", last name='" + lastName + '\'' +
                ", id=" + id +
                '}';
    }
}