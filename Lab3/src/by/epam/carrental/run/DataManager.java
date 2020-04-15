package by.epam.carrental.run;

import by.epam.carrental.collections.Gender;
import by.epam.carrental.entity.Car;
import by.epam.carrental.entity.Client;
import by.epam.carrental.entity.Order;
import by.epam.carrental.exception.CarException;
import by.epam.carrental.exception.UserException;
/*import by.epam.carrental.service.CarService;
import by.epam.carrental.service.OrderService;
import by.epam.carrental.service.UserService;*/

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class DataManager {

    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws CarException, UserException {
        try {
            String dbURL = "jdbc:oracle:thin:eugene/oracle@localhost:1521:orcl";
            Connection connection = DriverManager.getConnection(dbURL);
            if (connection != null) {
                System.out.println("CONNECTED SUCCESSFULLY " + connection);
            }
            String sql = "INSERT INTO CAR(CAR_NAME, CAR_MODEL, CAR_YEAR, CAR_PRICE, CAR_ID) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "SKODA");
            preparedStatement.setString(2, "RAPID");
            preparedStatement.setInt(3, 2018);
            preparedStatement.setBigDecimal(4, BigDecimal.valueOf(10.0));
            preparedStatement.setLong(5, 125);

            Integer rows = preparedStatement.executeUpdate();
            if (rows > 0) {
                System.out.println("CREATED SUCCESSFULLY");
            } else {
                throw new Exception("ENTITY IS NOT CREATED");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
        /*while (true) {
            System.out.println("Choose what to manage: \n1.User manager\n2.Car manager\n3.Order manager\n0.Exit");
            int choice = scan.nextInt();
            switch (choice) {
                case 1: {
                    userManager();
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

    private static void userManager() throws CarException, UserException {
        UserService controller = new UserService();
        controller.read();
        while (true) {
            System.out.println("Choose what to do: \n1.Add\n2.Delete\n3.Update\n4.Show All\n0.Back");
            int choice = scan.nextInt();
            switch (choice) {
                case 1: {
                    controller.create(userBuilder());
                    break;
                }
                case 2: {
                    controller.delete(userBuilder());
                    break;
                }
                case 3: {
                    controller.update(userBuilder());
                    break;
                }
                case 4: {
                    System.out.println(controller.getData().toString());
                    break;
                }
                case 0: {
                    controller.save();
                    main(new String[0]);
                }
                default:
                    continue;
            }
        }
    }

    private static void carManager() throws CarException, UserException {
        CarService controller = new CarService();
        controller.read();
        while (true) {
            System.out.println("Choose what to do: \n1.Add\n2.Delete\n3.Update\n4.Show All\n0.Back");
            int choice = scan.nextInt();
            switch (choice) {
                case 1: {
                    controller.create(carBuilder());
                    break;
                }
                case 2: {
                    controller.delete(carBuilder());
                    break;
                }
                case 3: {
                    controller.update(carBuilder());
                    break;
                }
                case 4: {
                    System.out.println(controller.getData().toString());
                    break;
                }
                case 0: {
                    controller.save();
                    main(new String[0]);
                }
                default:
                    continue;
            }
        }
    }

    private static void orderManager() throws CarException, UserException {
        OrderService controller = new OrderService();
        controller.read();
        while (true) {
            System.out.println("Choose what to do: \n1.Add\n2.Delete\n3.Update\n4.Show All\n0.Back");
            int choice = scan.nextInt();
            switch (choice) {
                case 1: {
                    controller.create(orderBuilder());
                    break;
                }
                case 2: {
                    controller.delete(orderBuilder());
                    break;
                }
                case 3: {
                    controller.update(orderBuilder());
                    break;
                }
                case 4: {
                    System.out.println(controller.getData().toString());
                    break;
                }
                case 0: {
                    controller.save();
                    main(new String[0]);
                }
                default:
                    continue;
            }
        }
    }

    public static Client userBuilder() throws UserException {
        Scanner sc = new Scanner(System.in);
        Client client = new Client();
        System.out.println("Enter first name:");
        client.setFirstName(sc.nextLine());
        System.out.println("Enter last name:");
        client.setLastName(sc.nextLine());
        System.out.println("Enter phone number:");
        //client.setPhoneNumber(sc.nextLine()); check this line
        System.out.println("Enter age:");
        client.setAge(sc.nextInt());
        System.out.println("Enter gender:");
        Gender gender = Gender.valueOf(sc.next().toUpperCase());
        client.setGender(gender);
        System.out.println("Your driving experience is more than two years? (Yes/No):");
        client.setDrivingExperience(sc.next());
        System.out.println("Enter category:");
        client.setCategory(sc.next());
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
        car.setId(sc.nextInt());
        return car;
    }

    public static Order orderBuilder() throws CarException, UserException {
        Scanner sc = new Scanner(System.in);
        Order order = new Order();
        order.setClient(userBuilder());
        order.setCar(carBuilder());
        System.out.println("Enter time (in hours):");
        order.setTime(sc.nextInt());
        return order;
    }*/