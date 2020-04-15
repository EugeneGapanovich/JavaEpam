package by.epam.carrental.entity;

import by.epam.carrental.exception.CarException;
import by.epam.carrental.validator.ValidYearOfCar;

import java.math.BigDecimal;
import java.util.Objects;

public class Car extends Entity{
    private String name;
    private String model;
    private Integer yearOfCar;
    private BigDecimal price;
    private Integer id;

    public Car() {
    }

    public Car(String name, String model, Integer yearOfCar, BigDecimal price, Integer id) throws CarException{
        this.name = name;
        this.model = model;
        setYearOfCar(yearOfCar);
        this.price = price;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getYearOfCar() {
        return yearOfCar;
    }

    public void setYearOfCar(Integer yearOfCar) throws CarException{
        if(ValidYearOfCar.isValidYearOfCar(yearOfCar)){
            this.yearOfCar = yearOfCar;
        } else{
            throw new CarException("Bad year of car");
        }
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int Integer) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(name, car.name) &&
                Objects.equals(model, car.model) &&
                Objects.equals(yearOfCar, car.yearOfCar) &&
                Objects.equals(price, car.price) &&
                Objects.equals(id, car.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, model, yearOfCar, price, id);
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", model='" + model + '\'' +
                ", year of car=" + yearOfCar +
                ", price=" + price +
                ", id=" + id +
                '}';
    }
}
