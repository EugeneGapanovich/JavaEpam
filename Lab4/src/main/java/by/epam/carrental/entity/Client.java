package by.epam.carrental.entity;

import by.epam.carrental.collections.Gender;
import by.epam.carrental.exception.UserException;
import by.epam.carrental.validator.ValidPhone;

import java.util.Objects;

public class Client extends User{
    private Integer age;
    private String phoneNumber;
    private Gender gender;
    private String drivingExperience;
    private String category;

    public Client(){
        super();
    }

    public Client(String firstName, String lastName, String phoneNumber, int age, String drivingExperience
            , String category, String gender, long id) throws UserException {
        super(firstName, lastName, id);
        setPhoneNumber(phoneNumber);
        this.age = age;
        this.gender = Gender.valueOf(gender);
        this.drivingExperience = drivingExperience;
        this.category = category;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender.toString();
    }

    public void setGender(String gender) {
        this.gender = Gender.valueOf(gender.toUpperCase());
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

    public String getPhoneNumber() {
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
        if (!super.equals(o)) return false;
        Client client = (Client) o;
        return Objects.equals(age, client.age) &&
                Objects.equals(phoneNumber, client.phoneNumber) &&
                gender == client.gender &&
                Objects.equals(drivingExperience, client.drivingExperience) &&
                Objects.equals(category, client.category);
    }


    @Override
    public String toString() {
        return "Client{" +
                "name='" + getFirstName() + '\'' +
                "; surname='" + getLastName() + '\'' +
                "; phone number='" + phoneNumber + '\'' +
                "; age='" + age + '\'' +
                "; gender='" + gender + '\'' +
                "; driving experience='" + drivingExperience + '\'' +
                "; category='" + category + '\'' +
                "; id='" + getId() + '\'' +
                '}';
    }
}
