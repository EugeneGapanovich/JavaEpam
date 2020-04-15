package by.epam.carrental.entity;

import by.epam.carrental.collections.Gender;
import by.epam.carrental.exception.UserException;

import java.util.Objects;

public class Client extends User{
    private Integer age;
    private Gender gender;
    private String drivingExperience;
    private String category;

    public Client(){
        super();
    }

    public Client(String firstName, String lastName, String phoneNumber, int age, Gender gender, String drivingExperience, String category) throws UserException {
        super(firstName, lastName, phoneNumber);
        this.age = age;
        this.gender = gender;
        this.drivingExperience = drivingExperience;
        this.category = category;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getDrivingExperience() {
        return drivingExperience;
    }

    public void setDrivingExperience(String drivingExperience) {
        this.drivingExperience = drivingExperience;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Client client = (Client) o;
        return Objects.equals(age, client.age) &&
                gender == client.gender &&
                Objects.equals(drivingExperience, client.drivingExperience) &&
                Objects.equals(category, client.category);
    }


    @Override
    public String toString() {
        return "Client{" +
                "name: " + getFirstName() + '\'' +
                "; surname: " + getLastName() + '\'' +
                "; phone number: " + "+" + getPhoneNumber() + '\'' +
                "; age: " + age + '\'' +
                "; gender: " + gender + '\'' +
                "; driving experience: " + drivingExperience + '\'' +
                "; category: '" + category + '\'' +
                '}';
    }
}
