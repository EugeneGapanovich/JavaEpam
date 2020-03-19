package by.epam.carrental.entity;

import by.epam.carrental.collections.Gender;

public class Client extends User{
    private int age;
    private Gender gender;
    private String drivingExperience;
    private String category;

    public Client(){
        super();
    }

    public Client(String firstName, String lastName, String phoneNumber, int age, Gender gender, String drivingExperience, String category) {
        super(firstName, lastName, phoneNumber);
        this.age = age;
        this.gender = gender;
        this.drivingExperience = drivingExperience;
        this.category = category;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
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
    public boolean equals(Object obj){
        if(this == obj) {
            return true;
        }
        if(obj == null || getClass() != obj.getClass()){
            return false;
        }
        Client that = (Client) obj;
        return that.age == age &&
                that.gender == gender &&
                that.drivingExperience == drivingExperience &&
                that.category == category;
    }

    @Override
    public String toString() {
        return "Client{" +
                "name: " + getFirstName() +
                "; surname: " + getLastName() +
                "; phone number: " + "+" + getPhoneNumber() +
                "; age: " + age +
                "; gender: " + gender +
                "; driving experience: " + drivingExperience +
                "; category: '" + category + '\'' +
                '}';
    }
}
