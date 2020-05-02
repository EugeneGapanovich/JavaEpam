package by.epam.carrental.entity;

import java.util.Objects;

public class Order {
    private Client client;
    private Car car;
    private Integer time;
    private long id;
    private long carId;
    private long clientId;

    public Order() {

    }

    public Order(Client client, Car car, Integer time, long id) {
        this.client = client;
        this.car = car;
        this.time = time;
        this.id = id;
    }

    public Order(long orderId, Integer time, long carId, long clientId) {
        this.id = orderId;
        this.time = time;
        this.carId = carId;
        this.clientId = clientId;
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

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCarId() {
        return carId;
    }

    public void setCarId(long carId) {
        this.carId = carId;
    }

    public long getClientId() {
        return clientId;
    }

    public void setClientId(long clientId) {
        this.clientId = clientId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(client, order.client) &&
                Objects.equals(car, order.car) &&
                Objects.equals(time, order.time) &&
                Objects.equals(id, order.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(client, car, time, id);
    }

    @Override
    public String toString() {
        return "Order{" +
                "client=" + client +
                ", car=" + car +
                ", time=" + time +
                ", id=" + id +
                '}';
    }
}
