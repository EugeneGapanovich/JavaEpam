package by.epam.carrental.entity;

public class Car extends Entity{
    private String name;
    private String model;
    private int yearOfCar;
    private double price;
    private int id;

    public Car() {

    }

    public Car(String name, String model, int yearOfCar, double price, int id) {
        this.name = name;
        this.model = model;
        this.yearOfCar = yearOfCar;
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

    public int getYearOfCar() {
        return yearOfCar;
    }

    public void setYearOfCar(int yearOfCar) {
        this.yearOfCar = yearOfCar;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int hashCode(){
        return id;
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj) {
            return true;
        }
        if(obj == null || getClass() != obj.getClass()){
            return false;
        }
        Car that = (Car) obj;
        return that.name == name &&
                that.model == model &&
                that.yearOfCar == yearOfCar &&
                Double.compare(that.price, price) == 0 &&
                that.id == id;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name: " + name +
                "; model: " + model +
                "; year of car manufacture: " + yearOfCar +
                "; price per hour: " + price + " BYN" +
                "; id: " + id +
                '}';
    }
}
