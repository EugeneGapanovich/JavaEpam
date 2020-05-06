package by.epam.carrental.run;

import by.epam.carrental.dao.CarDAO;
import by.epam.carrental.dao.ClientDAO;
import by.epam.carrental.dao.DAO;
import by.epam.carrental.dao.OrderDAO;
import by.epam.carrental.entity.Car;
import by.epam.carrental.entity.Client;
import by.epam.carrental.entity.Order;
import by.epam.carrental.exception.CarException;
import by.epam.carrental.exception.UserException;
import com.sun.jdi.LongValue;


import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Scanner;

public class DataManager {

    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws CarException, UserException, SQLException {

        Car car = new Car("SKODA", "RAPID", 2018, BigDecimal.valueOf(10), (long) 100);
        Car carr = new Car("W", "X5", 2018, BigDecimal.valueOf(10), (long) 200);
        Car carUpdated = new Car("SKODA", "RAPIDD", 2019, BigDecimal.valueOf(10), (long) 10);
        //CarDAO carDao = new CarDAO();
        //carDao.create(car);
        //carDao.create(carr);
        //carDao.read("10");
        //carDao.update(carUpdated);
        //carDao.delete("10");

        Order order = new Order(10,10,10,10);
        Order orderr = new Order(30,30,30,30);
        Order orderUpdated = new Order(30,10,10,20);
        //OrderDAO orderDao = new OrderDAO();
        //orderDao.create(order);
        //orderDao.create(orderr);
        //orderDao.read("10");
        //orderDao.update(orderUpdated);
        //orderDao.delete("10");

        Client client = new Client("CL","cl","+375331234567",20
                ,"yes","B","MALE",(long) 20);
        Client clientt = new Client("GF","gf","+375331234569",29
                ,"yes","B","MALE",(long) 28);
        Client clientUpdated = new Client("CL","cl","+375331234567",21
                ,"yes","B","MALE",(long) 20);
        ClientDAO clientDao = new ClientDAO();
        //lientDao.create(client);
        //clientDao.create(clientt);
        //clientDao.read("28");
        //clientDao.update(clientUpdated);
        //clientDao.delete("20");
    }
}

/*        while (true) {
            System.out.println("Choose what to manage: \n1.CLIENT DATABASE\n2.CAR DATABASE\n3.ORDER DATABASE\n0.Exit");
            int choice = scan.nextInt();
            switch (choice) {
                case 1: {
                    clientManager();
                    break;
                }
                case 2: {
                    carManager();
                    break;
                }
                case 3: {
                    orderManager();
                    break;
                }
                case 0:
                    System.exit(0);
                default:
                    continue;
            }
        }
    }

    private static void clientManager() throws CarException, UserException, SQLException {
        ClientService service = new ClientService();
        while (true) {
            System.out.println("Choose what to do: \n1.CREAT\n2.READ\n3.UPDATE\n4.DELETE\n0.Back");
            int choice = scan.nextInt();
            switch (choice) {
                case 1: {
                    service.create(clientBuilder());
                    break;
                }
                case 2: {
                    service.read(clientKey());
                    break;
                }
                case 3: {
                    service.update(clientBuilder());
                    break;
                }
                case 4: {
                    service.delete(clientKey());
                    break;
                }
                case 0: {
                    main(new String[0]);
                }
                default:
                    continue;
            }
        }
    }

    private static void carManager() throws CarException, UserException, SQLException {
        CarService service = new CarService();
        while (true) {
            System.out.println("Choose what to do: \n1.CREATE\n2.READ\n3.UPDATE\n4.DELETE\n0.Back");
            int choice = scan.nextInt();
            switch (choice) {
                case 1: {
                    service.create(carBuilder());
                    break;
                }
                case 2: {
                    service.read(carKey());
                    break;
                }
                case 3: {
                    service.update(carBuilder());
                    break;
                }
                case 4: {
                    service.delete(carKey());
                    break;
                }
                case 0: {
                    main(new String[0]);
                }
                default:
                    continue;
            }
        }
    }

    private static void orderManager() throws CarException, UserException, SQLException {
        OrderService service = new OrderService();
        while (true) {
            System.out.println("Choose what to do: \n1.CREATE\n2.READ\n3.UPDATE\n4.DELETE\n0.Back");
            int choice = scan.nextInt();
            switch (choice) {
                case 1: {
                    service.create(orderBuilder());
                    break;
                }
                case 2: {
                    service.read(orderKey());
                    break;
                }
                case 3: {
                    service.update(orderBuilder());
                    break;
                }
                case 4: {
                    service.delete(orderKey());
                    break;
                }
                case 0: {
                    main(new String[0]);
                }
                default:
                    continue;
            }
        }
    }

    public static Client clientBuilder() throws UserException {
        Scanner sc = new Scanner(System.in);
        Client client = new Client();
        System.out.println("Enter first name:");
        client.setFirstName(sc.nextLine());
        System.out.println("Enter last name:");
        client.setLastName(sc.nextLine());
        System.out.println("Enter phone number:");
        client.setPhoneNumber(sc.nextLine());
        System.out.println("Enter age:");
        client.setAge(sc.nextInt());
        System.out.println("Enter category:");
        client.setCategory(sc.next().toUpperCase());
        System.out.println("Your driving experience is more than two years? (Yes/No):");
        client.setDrivingExperience(sc.next());
        System.out.println("Enter gender:");
        client.setGender(sc.next().toUpperCase());
        System.out.println("Enter id:");
        client.setId(sc.nextLong());
        return client;
    }

    public static Car carBuilder() throws CarException {
        Scanner sc = new Scanner(System.in);
        Car car = new Car();
        System.out.println("Enter name:");
        car.setName(sc.nextLine());
        System.out.println("Enter model: ");
        car.setModel(sc.nextLine());
        System.out.println("Enter year of car manufacture:");
        car.setYearOfCar(sc.nextInt());
        System.out.println("Enter price per hour:");
        car.setPrice(sc.nextBigDecimal());
        System.out.println("Enter id:");
        car.setId(sc.nextLong());
        return car;
    }

    public static Order orderBuilder() throws CarException, UserException {
        Scanner sc = new Scanner(System.in);
        Order order = new Order();
        System.out.println("Enter order id:");
        order.setId(sc.nextLong());
        System.out.println("Enter time (in hours):");
        order.setTime(sc.nextInt());
        System.out.println("Enter car id:");
        order.setCarId(sc.nextLong());
        System.out.println("Enter client id:");
        order.setClientId(sc.nextLong());
        return order;
    }

    public static String carKey(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter car id: ");
        return sc.nextLine();
    };

    public static String clientKey(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter client id: ");
        return sc.nextLine();
    };
    public static String orderKey(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter order id: ");
        return sc.nextLine();
    };*/