/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author OsamaAyman
 */
package Airport;
import java.util.*;
import java.util.Scanner;
public class Airports {
    String name ="Cairo Airport";
}
abstract class Person {

    String name;
    int age;
    String address;

    public Person(int a, String n,String s) {
        name = n;
        age = a;
        address = s;

    }
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    public String getAddress(){
        return address;
    }
    abstract public double applyDiscount(double p);

}
abstract class Passenger extends Person {

    int number;

    public Passenger (int a,String n,String s, int w){
        super(a,n,s);
        number = w;
        
    }
        
    @Override
    public String getName(){
        return name;
    }

    public int getNumber(){
        return number;
    }

}

class Member extends Passenger {

    private int yearsOfMembership;

    public Member(int yom, int a, String n,String s,int w) {
        super(a, n,s,w);
        yearsOfMembership = yom;

    }

    public double applyDiscount(double p) {
        if (yearsOfMembership > 5) {
            p = p / 2;
            return p;
        } else if (yearsOfMembership <= 5 && yearsOfMembership > 1) {
            p = (p *9)/10;
            return p;
        }
        return p;

    }
}
class NonMember  extends Passenger {

    public NonMember(int a, String n,String s,int w) {
        super(a, n,s,w);
    }

    public double applyDiscount(double p) {
        if (age > 65) {
            p = (p *9)/10;
            return p;
        }
        return p;
    }

}
class Flight  {

    private int flightNumber;
    private String origin;
    private String destination;
    private String departureTime;
    private String arrivalTime;
    private String date;
    private int capacity;
    private int numberOfSeatsleft;
    private double originalPrice;

    public Flight(int fn, String o, String ds, String dp,String ar, String dt, int c, double op) {
        if (ds.equals(o) == true) {
            throw new IllegalArgumentException("destination and origin are the same");
        }
        flightNumber = fn;
        origin = o;
        destination = ds;
        departureTime = dp;
        arrivalTime = ar;
        date = dt;
        capacity = c;
        numberOfSeatsleft = c;
        originalPrice = op;
    }

    public boolean bookASeat() {
        if (numberOfSeatsleft > 0) {
            numberOfSeatsleft = numberOfSeatsleft - 1;
            return true;

        }
        return false;
    }

    public double getPrice() {
        return originalPrice;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDestination() {
        return destination;
    }

    public String getDepartureTime() {
        return departureTime;
    }
    
    public String getArrivalTime() {
        return arrivalTime;
    }
        
    public String getDate(){
        return date;
    }
    
    public int getFlightNumber() {
        return flightNumber;
    }

    public int getNumberOfSeatsleft() {
        return numberOfSeatsleft;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setPrice(double p) {
        originalPrice = p;
    }

    public void setOrigin(String o) {
        origin = o;
    }

    public void setDestination(String d) {
        destination = d;
    }
        
    public void setDepartureTime(String dr) {
        departureTime = dr;
    }
    
    public void setArrivalTime(String ar) {
        arrivalTime = ar;
    }

    public void setDate(String dt){
        date = dt;
    }
    
    public void setFlightNumber(int fn) {
        flightNumber = fn;
    }

    public void setNumberOfSeatsleft(int s) {
        numberOfSeatsleft = s;
    }

    public void setCapacity(int c) {
        capacity = c;
    }

    @Override
    public String toString() {
        String one = " Flight " + flightNumber;
        String two = " , From " + origin + " to " + destination;
        String three = " , Departure : " + departureTime;
        String four = " , Arrival : " + arrivalTime;
        String five = " , original price : " + originalPrice + " $";
        return one + two + three + four + five;
    }

}
    
class Ticket  {

    private Flight flight;
    private Passenger passenger;
    private double price;
    private int number;
    private static int count = 0;

    public Ticket(Flight f, Passenger pa, double pr) {
        count++;
        flight = f;
        passenger = pa;
        price = pr;
        number = count;


    }

    @Override
    public String toString() {
        String one = passenger.getName() + " , Flight " + flight.getFlightNumber();
        String two = " , From " + flight.getOrigin() + " to " + flight.getDestination();
        String three = " , Departure : " + flight.getDepartureTime();
        String four = " , Arrival : " + flight.getArrivalTime();
        String five = " , original price : " + flight.getPrice() + " $";
        String six = " , ticket price : " + price + " $";
        return one + two + three + four + five + six;
    }

    public Flight getFlight() {
        return flight;
    }
    public void setFlight(Flight F) {
        flight=F;
    }
     public Passenger getPassenger() {
        return passenger;
    }
    public void setPassenger(Passenger P) {
        passenger=P;
    }
     public double getPrice() {
        return price;
    }
    public void setPrice(double P) {
        price=P;
    }
     public int getNumber() {
        return number;
    }
    public void setNumber(int n) {
        number=n;
    }
    public int getCount() {
        return count;
    }
    public void setCount(int n) {
        count=n;
    }
    
    
}
class Reservation {

    List<Flight> flights;
    List<Ticket> tickets;

    public Reservation() {
        flights = new ArrayList<>();
        tickets = new ArrayList<>();

    }

    public void createFlights() {
        int FN, c;
        double op;
        String origin, destination, dr ,ar,dt;
        Scanner scan1 = new Scanner(System.in);
        Scanner scan2 = new Scanner(System.in);
        Scanner scan3 = new Scanner(System.in);
        System.out.println("Enter flight Number");
        FN = scan1.nextInt();
        System.out.println("Enter flight origin");
        origin = scan2.nextLine();
        System.out.println("Enter flight destination");
        destination = scan2.nextLine();
        System.out.println("Enter flight departure time ");
        dr = scan2.nextLine();
        System.out.println("Enter flight Arrival time ");
        ar = scan2.nextLine();
        System.out.println("Enter flight date ");
        dt = scan2.nextLine();
        System.out.println("Enter flight capacity");
        c = scan1.nextInt();
        System.out.println("Enter original price of ticket");
        op = scan3.nextDouble();
        Flight F = new Flight(FN, origin, destination, dr, ar, dt, c, op);
        flights.add(F);
        System.out.println("-----------------------------------");
        System.out.println("The following flight has been created:");
        System.out.println(F);

    }

    public void displayAvailableFlights(String origin, String destination) {
        int size, seats;
        boolean flag = true;
        String o, d;
        size = flights.size();
        for (int i = 0; i < size; i++) {
            o = flights.get(i).getOrigin();
            d = flights.get(i).getDestination();
            seats = flights.get(i).getNumberOfSeatsleft();
            if ((o.equals(origin) == true) && (d.equals(destination) == true) && seats > 0) {
                if (flag == true) {
                    System.out.println("List of available flights:");
                    flag = false;
                }
                System.out.println(flights.get(i));
            }
        }
        if (flag == true) {
            System.out.println("no available flights");
        }



    }

    public Flight getFlight(int flightNumber) {
        int size = flights.size();
        for (int i = 0; i < size; i++) {
            if (flights.get(i).getFlightNumber() == flightNumber) {
                return flights.get(i);
            }

        }
        return null;
    }

    public void bookSeat(int flightNumber, Passenger p) {
        int size = flights.size();
        boolean flag = false;
        int index = 0, seats;
        for (int i = 0; i < size; i++) {
            if (flights.get(i).getFlightNumber() == flightNumber) {
                flag = true;
                index = i;
                break;
            }

        }
        double price;
        seats = flights.get(index).getNumberOfSeatsleft();
        if (flag == true && (seats > 0)) {
            flights.get(index).bookASeat();
            price = p.applyDiscount(flights.get(index).getPrice());
            Ticket a = new Ticket(flights.get(index), p, price);
            tickets.add(a);
            System.out.println("you have succesfully booked a seat for flight " + flightNumber);
            System.out.println("ticket: " + a);
        }

        else {
            if (flag == true && seats == 0) {
                System.out.println("The Flight " + flightNumber + " is full you cannot book a ticket for this flight");

            } else if (flag == false) {
                System.out.println("The Flight " + flightNumber + " cdoes not exist");
            }
        }

    }

    public static void main(String[] args) {
        Reservation M = new Reservation();
        Flight F;
        Passenger P;
        Scanner scan1 = new Scanner(System.in);
        Scanner scan2 = new Scanner(System.in);
        String input, destination, origin, name, address;
        int FN, number, years,age;
        boolean flag = false;

        while (flag != true) {
            System.out.println("-------------------------------------------- ");
            System.out.println("Welcome to Cairo Airport ");
            System.out.println("Enter c if you would like to create a flight (creatFlight method)");
            System.out.println("Enter d if you would like to display all flights (displayAvailableFlights method)");
            System.out.println("Enter g if you would like to get information on a flight (getFlight method)");
            System.out.println("Enter b if you would like to book a seat (bookSeat method)");
            System.out.println("Enter t if you would like to terminate the program");
            input = scan1.nextLine();
            switch (input) {
                case "c":
                    M.createFlights();
                    break;
                case "d":
                    System.out.println("Enter flight origin");
                    origin = scan1.nextLine();
                    System.out.println("Enter flight destination");
                    destination = scan1.nextLine();
                    System.out.println("-----------------------------------");
                    M.displayAvailableFlights(origin, destination);
                    break;
                case "g":
                    System.out.println("Enter Flight number");
                    FN = scan2.nextInt();
                    F = M.getFlight(FN);
                    if (F == null) {
                        System.out.println("-----------------------------------");
                        System.out.println("Flight " + FN + " does not exist");
                    } else {
                        System.out.println("-----------------------------------");
                        System.out.println("Info for Flight " + FN + ":");
                        System.out.println(F);
                    }
                    break;
                case "b":
                    System.out.println("---------------------------------------------------------");
                    System.out.println("If passenger is non memeber enter n, if passenger is a member enter m");
                    input = scan1.nextLine();
                    System.out.println("-----------------------------------");

                    System.out.println("Enter passengers name");
                    name = scan1.nextLine();
                    System.out.println("-----------------------------------");
                    System.out.println("Enter passengers address");
                    address = scan1.nextLine();
                    System.out.println("-----------------------------------");
                    System.out.println("Enter passengers Age");
                    age = scan2.nextInt();
                    System.out.println("-----------------------------------");
                    System.out.println("Enter passengers number");
                    number = scan2.nextInt();
                    System.out.println("-----------------------------------");
                    System.out.println("Enter flight number");
                    FN = scan2.nextInt();                    
                    if (input.equals("n") == true) {
                        P = new NonMember(age, name, address,number);
                        System.out.println("-----------------------------------");
                        M.bookSeat(FN, P);
                    } else if (input.equals("m") == true) {
                        System.out.println("-----------------------------------");
                        System.out.println("For how many years has the passenger been a member");
                        years = scan2.nextInt();
                        P = new Member(years, age, name, address,number);
                        System.out.println("-----------------------------------");
                        M.bookSeat(FN, P);
                        

                    }
                    break;
                case "t":
                    flag = true;
                    System.out.println("-----------------------------------");
                    System.out.println("Program is terminated");
                    break;
                default:
                    System.out.println("-----------------------------------");
                    System.out.println("You entered an invalid option");
                    break;

            }

        }

    }
}