package by.epam.carrental.entity;

public class Order {
    private Client client;
    private Car car;
    private int time;
    private int id;

    public Order() {

    }

    public Order(Client client, Car car, int time, int id) {
        this.client = client;
        this.car = car;
        this.time = time;
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
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
        Order that = (Order) obj;
        return that.client == client &&
                that.car == car &&
                that.time == time &&
                that.id == id;
    }

    @Override
    public String toString() {
        return "Order{" +
                "name: " + client.getFirstName() +
                "; surname: " + client.getLastName() +
                "; number phone: " + client.getPhoneNumber() +
                "; age: " + client.getAge() +
                "; gender: " + client.getGender() +
                "; driving experience: " + client.getDrivingExperience() +
                "; category: " + client.getCategory() +
                "; car name: " + car.getName() +
                "; model: " + car.getModel() +
                "; year of car manufacture: " + car.getYearOfCar() +
                "; car id: " + car.getId() +
                "; price per hour: " + car.getPrice() +
                "; time: " + time + " hours" +
                '}';
    }
}
