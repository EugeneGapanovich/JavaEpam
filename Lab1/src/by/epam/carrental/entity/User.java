package by.epam.carrental.entity;

import java.util.Objects;

public abstract class User extends Entity{
    private String firstName;
    private String lastName;
    private String phoneNumber;

    public User() {
    }

    public User(String firstName, String lastName, String phoneNumber){
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
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

    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    @Override
    public int hashCode(){
        return Objects.hash(phoneNumber);
    }

    @Override
    public String toString() {
        return "User{" +
                "name: " + firstName +
                "; surname: " + lastName +
                "; phone number: '" + "+" + phoneNumber + '\'' +
                '}';
    }
}