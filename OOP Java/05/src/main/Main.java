package main;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
//        LocalDate date = LocalDate.of(2020, 11, 12);
//        for (int i = 0; i < 5; i++) {
//            System.out.println(date.plusYears(i).getDayOfWeek());
//        }
//
//        LocalDate startOfWar = LocalDate.of(1939, 9, 1);
//        LocalDate endOfWar = LocalDate.of(1945, 9, 2);
//        dateDifference(startOfWar, endOfWar);
//
//    }
//    public static void dateDifference(LocalDate dateStart, LocalDate dateEnd){
//        int result = (dateEnd.getDayOfYear()+1 + dateEnd.getYear()*365 + dateEnd.getYear()/4) - (dateStart.getDayOfYear() + dateStart.getYear()*365 + dateStart.getYear()/4);
//        if (dateStart.getYear()%4 == 0){
//            result++;
//        }if (dateEnd.getYear()%4 == 0){
//            result++;
//        }
//        System.out.println("It lasted " + result + " days");

    }
}
class Vehicle{
    Window[] windows;
    String color, fuelType, producer;
    Engine engine;
    int maxSpeed;
    int commandAmount;

    public Vehicle(Window[] windows, String color, String fuelType, String producer, Engine engine, int maxSpeed, int commandAmount) {
        this.windows = windows;
        this.color = color;
        this.fuelType = fuelType;
        this.producer = producer;
        this.engine = engine;
        this.maxSpeed = maxSpeed;
        this.commandAmount = commandAmount;
    }
}
class Auto extends Vehicle{
    Mirror[] mirrors;
    int wheelAmount, doorAmount;
    int stateNumber;
    boolean hasCruiseControl;

    public Auto(Window[] windows, String color, String fuelType, String producer, Engine engine, int maxSpeed, int commandAmount, Mirror[] mirrors, int wheelAmount, int doorAmount, int stateNumber, boolean hasCruiseControl) {
        super(windows, color, fuelType, producer, engine, maxSpeed, commandAmount);
        this.mirrors = mirrors;
        this.wheelAmount = wheelAmount;
        this.doorAmount = doorAmount;
        this.stateNumber = stateNumber;
        this.hasCruiseControl = hasCruiseControl;
    }
}
class Car extends Auto{
    int seetAmount;
    boolean hasBabySeet;

    public Car(Window[] windows, String color, String fuelType, String producer, Engine engine, int maxSpeed, int commandAmount, Mirror[] mirrors, int wheelAmount, int doorAmount, int stateNumber, boolean hasCruiseControl, int seetAmount, boolean hasBabySeet) {
        super(windows, color, fuelType, producer, engine, maxSpeed, commandAmount, mirrors, wheelAmount, doorAmount, stateNumber, hasCruiseControl);
        this.seetAmount = seetAmount;
        this.hasBabySeet = hasBabySeet;
    }
}
class Truck extends Auto{
    int tonnage;

    public Truck(Window[] windows, String color, String fuelType, String producer, Engine engine, int maxSpeed, int commandAmount, Mirror[] mirrors, int wheelAmount, int doorAmount, int stateNumber, boolean hasCruiseControl, int tonnage) {
        super(windows, color, fuelType, producer, engine, maxSpeed, commandAmount, mirrors, wheelAmount, doorAmount, stateNumber, hasCruiseControl);
        this.tonnage = tonnage;
    }
}
class Trailer extends Truck{
    int drayLength;
    boolean hasAirBag;

    public Trailer(Window[] windows, String color, String fuelType, String producer, Engine engine, int maxSpeed, int commandAmount, Mirror[] mirrors, int wheelAmount, int doorAmount, int stateNumber, boolean hasCruiseControl, int tonnage, int drayLength, boolean hasAirBag) {
        super(windows, color, fuelType, producer, engine, maxSpeed, commandAmount, mirrors, wheelAmount, doorAmount, stateNumber, hasCruiseControl, tonnage);
        this.drayLength = drayLength;
        this.hasAirBag = hasAirBag;
    }
}
class Bus extends Auto{
    String routType;
    int passengerAmount;
    boolean hasBaggageSection;

    public Bus(Window[] windows, String color, String fuelType, String producer, Engine engine, int maxSpeed, int commandAmount, Mirror[] mirrors, int wheelAmount, int doorAmount, int stateNumber, boolean hasCruiseControl, String routType, int passengerAmount, boolean hasBaggageSection) {
        super(windows, color, fuelType, producer, engine, maxSpeed, commandAmount, mirrors, wheelAmount, doorAmount, stateNumber, hasCruiseControl);
        this.routType = routType;
        this.passengerAmount = passengerAmount;
        this.hasBaggageSection = hasBaggageSection;
    }
}
class Plane extends Vehicle{
    Wing[] wings;
    Chassis[] chassis;
    int flyLength;
    int flyHeight;

    public Plane(Window[] windows, String color, String fuelType, String producer, Engine engine, int maxSpeed, int commandAmount, Wing[] wings, Chassis[] chassis, int flyLength, int flyHeight) {
        super(windows, color, fuelType, producer, engine, maxSpeed, commandAmount);
        this.wings = wings;
        this.chassis = chassis;
        this.flyLength = flyLength;
        this.flyHeight = flyHeight;
    }
}
class Ship extends Vehicle{
    Anchor anchor;
    int tonnage;
    Boat[] boats;

    public Ship(Window[] windows, String color, String fuelType, String producer, Engine engine, int maxSpeed, int commandAmount, Anchor anchor, int tonnage, Boat[] boats) {
        super(windows, color, fuelType, producer, engine, maxSpeed, commandAmount);
        this.anchor = anchor;
        this.tonnage = tonnage;
        this.boats = boats;
    }
}

class PassengerPlane extends Plane{
    int passengerAmount;

    public PassengerPlane(Window[] windows, String color, String fuelType, String producer, Engine engine, int maxSpeed, int commandAmount, Wing[] wings, Chassis[] chassis, int flyLength, int flyHeight, int passengerAmount) {
        super(windows, color, fuelType, producer, engine, maxSpeed, commandAmount, wings, chassis, flyLength, flyHeight);
        this.passengerAmount = passengerAmount;
    }
}
class AirFreighter extends Plane{
    int tonnage;
    int cargoholdHeight;

    public AirFreighter(Window[] windows, String color, String fuelType, String producer, Engine engine, int maxSpeed, int commandAmount, Wing[] wings, Chassis[] chassis, int flyLength, int flyHeight, int tonnage, int cargoholdHeight) {
        super(windows, color, fuelType, producer, engine, maxSpeed, commandAmount, wings, chassis, flyLength, flyHeight);
        this.tonnage = tonnage;
        this.cargoholdHeight = cargoholdHeight;
    }
}
class Fighter extends Plane{
    String generationType;
    int gunAmount;
    int rocketAmount;

    public Fighter(Window[] windows, String color, String fuelType, String producer, Engine engine, int maxSpeed, int commandAmount, Wing[] wings, Chassis[] chassis, int flyLength, int flyHeight, String generationType, int gunAmount, int rocketAmount) {
        super(windows, color, fuelType, producer, engine, maxSpeed, commandAmount, wings, chassis, flyLength, flyHeight);
        this.generationType = generationType;
        this.gunAmount = gunAmount;
        this.rocketAmount = rocketAmount;
    }
}
class Boat{} class Anchor{} class Mirror{} class Engine{}
class Window{} class Wing{} class Chassis{}
