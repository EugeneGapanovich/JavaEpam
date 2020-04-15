package by.epam.carrental.entity;

import by.epam.carrental.exception.UserException;
import by.epam.carrental.validator.ValidPhone;

import java.util.Objects;

public abstract class User extends Entity{
    private String firstName;
    private String lastName;
    private String phoneNumber;

    public User() {
    }

    public User(String firstName, String lastName, String phoneNumber) throws UserException{
        this.firstName = firstName;
        this.lastName = lastName;
        setPhoneNumber(phoneNumber);
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

    public String getPhoneNumber(){
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) throws UserException{
        if(ValidPhone.isValidPhone(phoneNumber)){
            this.phoneNumber = phoneNumber;
        } else{
            throw new UserException("Bad phone number");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(firstName, user.firstName) &&
                Objects.equals(lastName, user.lastName) &&
                Objects.equals(phoneNumber, user.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, phoneNumber);
    }

    @Override
    public String toString() {
        return "User{" +
                "first name='" + firstName + '\'' +
                ", last name='" + lastName + '\'' +
                ", phone number='" + phoneNumber + '\'' +
                '}';
    }
}