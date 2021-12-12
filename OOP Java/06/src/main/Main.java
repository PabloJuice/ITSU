package main;

import java.util.Arrays;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        Window[] windows = {new Window(), new Window(), new Window()};
        Vehicle vehicleOne = new Vehicle(windows, "Black", "Diesel", "Boeing",
                new Engine(), 600, 4);
        Vehicle vehicleTwo = new Vehicle(windows, "Black", "Diesel", "Boeing",
                new Engine(), 600, 4);
        System.out.println(vehicleOne.equals(vehicleTwo));
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

    public void transport(){
        System.out.println("nothing to transport");
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "windows  = " + Arrays.toString(windows) +
                ", color  = " + color +
                ", fuelType  = " + fuelType +
                ", producer  = " + producer +
                ", engine  = " + engine +
                ", maxSpeed  = " + maxSpeed +
                ", commandAmount  = " + commandAmount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vehicle)) return false;
        Vehicle vehicle = (Vehicle) o;
        return maxSpeed == vehicle.maxSpeed &&
                commandAmount == vehicle.commandAmount &&
                Arrays.equals(windows, vehicle.windows) &&
                color.equals(vehicle.color) &&
                fuelType.equals(vehicle.fuelType) &&
                producer.equals(vehicle.producer) &&
                engine.equals(vehicle.engine);
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
    @Override
    public void transport(){
        System.out.println("still nothing to transport");
    }

    @Override
    public String toString() {
        return "Auto{" +
                "windows = " + Arrays.toString(windows) +
                ", color = " + color +
                ", fuelType = " + fuelType +
                ", producer = " + producer +
                ", engine = " + engine +
                ", maxSpeed = " + maxSpeed +
                ", commandAmount = " + commandAmount +
                ", mirrors = " + Arrays.toString(mirrors) +
                ", wheelAmount = " + wheelAmount +
                ", doorAmount = " + doorAmount +
                ", stateNumber = " + stateNumber +
                ", hasCruiseControl = " + hasCruiseControl +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Auto)) return false;
        if (!super.equals(o)) return false;
        Auto auto = (Auto) o;
        return wheelAmount == auto.wheelAmount &&
                doorAmount == auto.doorAmount &&
                stateNumber == auto.stateNumber &&
                hasCruiseControl == auto.hasCruiseControl &&
                Arrays.equals(mirrors, auto.mirrors);
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
    @Override
    public void transport(){
        System.out.println("transporting passagers");
    }

    @Override
    public String toString() {
        return "Car{" +
                "windows = " + Arrays.toString(windows) +
                ", color = " + color +
                ", fuelType = " + fuelType +
                ", producer = " + producer +
                ", engine = " + engine +
                ", maxSpeed = " + maxSpeed +
                ", commandAmount = " + commandAmount +
                ", mirrors = " + Arrays.toString(mirrors) +
                ", wheelAmount = " + wheelAmount +
                ", doorAmount = " + doorAmount +
                ", stateNumber = " + stateNumber +
                ", hasCruiseControl = " + hasCruiseControl +
                ", seetAmount = " + seetAmount +
                ", hasBabySeet = " + hasBabySeet +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        if (!super.equals(o)) return false;
        Car car = (Car) o;
        return seetAmount == car.seetAmount &&
                hasBabySeet == car.hasBabySeet;
    }
}
class Truck extends Auto{
    int tonnage;

    public Truck(Window[] windows, String color, String fuelType, String producer, Engine engine, int maxSpeed, int commandAmount, Mirror[] mirrors, int wheelAmount, int doorAmount, int stateNumber, boolean hasCruiseControl, int tonnage) {
        super(windows, color, fuelType, producer, engine, maxSpeed, commandAmount, mirrors, wheelAmount, doorAmount, stateNumber, hasCruiseControl);
        this.tonnage = tonnage;
    }
    @Override
    public void transport(){
        System.out.println("transporting orders");
    }
    @Override
    public String toString() {
        return "Truck{" +
                "windows = " + Arrays.toString(windows) +
                ", color = " + color +
                ", fuelType = " + fuelType +
                ", producer = " + producer +
                ", engine = " + engine +
                ", maxSpeed = " + maxSpeed +
                ", commandAmount = " + commandAmount +
                ", mirrors = " + Arrays.toString(mirrors) +
                ", wheelAmount = " + wheelAmount +
                ", doorAmount = " + doorAmount +
                ", stateNumber = " + stateNumber +
                ", hasCruiseControl = " + hasCruiseControl +
                ", tonnage = " + tonnage +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Truck)) return false;
        if (!super.equals(o)) return false;
        Truck truck = (Truck) o;
        return tonnage == truck.tonnage;
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

    @Override
    public String toString() {
        return "Trailer{" +
                "windows = " + Arrays.toString(windows) +
                ", color = " + color +
                ", fuelType = " + fuelType +
                ", producer = " + producer +
                ", engine = " + engine +
                ", maxSpeed = " + maxSpeed +
                ", commandAmount = " + commandAmount +
                ", mirrors = " + Arrays.toString(mirrors) +
                ", wheelAmount = " + wheelAmount +
                ", doorAmount = " + doorAmount +
                ", stateNumber = " + stateNumber +
                ", hasCruiseControl = " + hasCruiseControl +
                ", tonnage = " + tonnage +
                ", drayLength = " + drayLength +
                ", hasAirBag = " + hasAirBag +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Trailer)) return false;
        if (!super.equals(o)) return false;
        Trailer trailer = (Trailer) o;
        return drayLength == trailer.drayLength &&
                hasAirBag == trailer.hasAirBag;
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

    @Override
    public String toString() {
        return "Bus{" +
                "windows = " + Arrays.toString(windows) +
                ", color = " + color +
                ", fuelType = " + fuelType +
                ", producer = " + producer +
                ", engine = " + engine +
                ", maxSpeed = " + maxSpeed +
                ", commandAmount = " + commandAmount +
                ", mirrors = " + Arrays.toString(mirrors) +
                ", wheelAmount = " + wheelAmount +
                ", doorAmount = " + doorAmount +
                ", stateNumber = " + stateNumber +
                ", hasCruiseControl = " + hasCruiseControl +
                ", routType = " + routType +
                ", passengerAmount = " + passengerAmount +
                ", hasBaggageSection = " + hasBaggageSection +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bus)) return false;
        if (!super.equals(o)) return false;
        Bus bus = (Bus) o;
        return passengerAmount == bus.passengerAmount &&
                hasBaggageSection == bus.hasBaggageSection &&
                routType.equals(bus.routType);
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

    @Override
    public String toString() {
        return "Plane{" +
                "windows = " + Arrays.toString(windows) +
                ", color = " + color +
                ", fuelType = " + fuelType +
                ", producer = " + producer +
                ", engine = " + engine +
                ", maxSpeed = " + maxSpeed +
                ", commandAmount = " + commandAmount +
                ", wings = " + Arrays.toString(wings) +
                ", chassis = " + Arrays.toString(chassis) +
                ", flyLength = " + flyLength +
                ", flyHeight = " + flyHeight +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Plane)) return false;
        if (!super.equals(o)) return false;
        Plane plane = (Plane) o;
        return flyLength == plane.flyLength &&
                flyHeight == plane.flyHeight &&
                Arrays.equals(wings, plane.wings) &&
                Arrays.equals(chassis, plane.chassis);
    }
}
class PassengerPlane extends Plane{
    int passengerAmount;

    public PassengerPlane(Window[] windows, String color, String fuelType, String producer, Engine engine, int maxSpeed, int commandAmount, Wing[] wings, Chassis[] chassis, int flyLength, int flyHeight, int passengerAmount) {
        super(windows, color, fuelType, producer, engine, maxSpeed, commandAmount, wings, chassis, flyLength, flyHeight);
        this.passengerAmount = passengerAmount;
    }

    @Override
    public String toString() {
        return "PassengerPlane{" +
                "windows = " + Arrays.toString(windows) +
                ", color = " + color +
                ", fuelType = " + fuelType +
                ", producer = " + producer +
                ", engine = " + engine +
                ", maxSpeed = " + maxSpeed +
                ", commandAmount = " + commandAmount +
                ", wings = " + Arrays.toString(wings) +
                ", chassis = " + Arrays.toString(chassis) +
                ", flyLength = " + flyLength +
                ", flyHeight = " + flyHeight +
                ", passengerAmount = " + passengerAmount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PassengerPlane)) return false;
        if (!super.equals(o)) return false;
        PassengerPlane that = (PassengerPlane) o;
        return passengerAmount == that.passengerAmount;
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

    @Override
    public String toString() {
        return "AirFreighter{" +
                "windows = " + Arrays.toString(windows) +
                ", color = " + color +
                ", fuelType = " + fuelType +
                ", producer = " + producer +
                ", engine = " + engine +
                ", maxSpeed = " + maxSpeed +
                ", commandAmount = " + commandAmount +
                ", wings = " + Arrays.toString(wings) +
                ", chassis = " + Arrays.toString(chassis) +
                ", flyLength = " + flyLength +
                ", flyHeight = " + flyHeight +
                ", tonnage = " + tonnage +
                ", cargoholdHeight = " + cargoholdHeight +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AirFreighter)) return false;
        if (!super.equals(o)) return false;
        AirFreighter that = (AirFreighter) o;
        return tonnage == that.tonnage &&
                cargoholdHeight == that.cargoholdHeight;
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

    @Override
    public String toString() {
        return "Fighter{" +
                "windows = " + Arrays.toString(windows) +
                ", color = " + color +
                ", fuelType = " + fuelType +
                ", producer = " + producer +
                ", engine = " + engine +
                ", maxSpeed = " + maxSpeed +
                ", commandAmount = " + commandAmount +
                ", wings = " + Arrays.toString(wings) +
                ", chassis = " + Arrays.toString(chassis) +
                ", flyLength = " + flyLength +
                ", flyHeight = " + flyHeight +
                ", generationType = " + generationType +
                ", gunAmount = " + gunAmount +
                ", rocketAmount = " + rocketAmount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Fighter)) return false;
        if (!super.equals(o)) return false;
        Fighter fighter = (Fighter) o;
        return gunAmount == fighter.gunAmount &&
                rocketAmount == fighter.rocketAmount &&
                generationType.equals(fighter.generationType);
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

    @Override
    public String toString() {
        return "Ship{" +
                "windows = " + Arrays.toString(windows) +
                ", color = " + color +
                ", fuelType = " + fuelType +
                ", producer = " + producer +
                ", engine = " + engine +
                ", maxSpeed = " + maxSpeed +
                ", commandAmount = " + commandAmount +
                ", anchor = " + anchor +
                ", tonnage = " + tonnage +
                ", boats = " + Arrays.toString(boats) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ship)) return false;
        if (!super.equals(o)) return false;
        Ship ship = (Ship) o;
        return tonnage == ship.tonnage &&
                anchor.equals(ship.anchor) &&
                Arrays.equals(boats, ship.boats);
    }
}

class СruiseShip extends Ship{
    int passengerAmount;
    int cabinsAmount;
    Accommodation[] accommodation;

    public СruiseShip(Window[] windows, String color, String fuelType, String producer, Engine engine, int maxSpeed, int commandAmount, Anchor anchor, int tonnage, Boat[] boats, int passengerAmount, int cabinsAmount, Accommodation[] accommodation) {
        super(windows, color, fuelType, producer, engine, maxSpeed, commandAmount, anchor, tonnage, boats);
        this.passengerAmount = passengerAmount;
        this.cabinsAmount = cabinsAmount;
        this.accommodation = accommodation;
    }

    @Override
    public String toString() {
        return "СruiseShip{" +
                "windows = " + Arrays.toString(windows) +
                ", color = " + color +
                ", fuelType = " + fuelType +
                ", producer = " + producer +
                ", engine = " + engine +
                ", maxSpeed = " + maxSpeed +
                ", commandAmount = " + commandAmount +
                ", anchor = " + anchor +
                ", tonnage = " + tonnage +
                ", boats = " + Arrays.toString(boats) +
                ", passengerAmount = " + passengerAmount +
                ", cabinsAmount = " + cabinsAmount +
                ", accommodation = " + Arrays.toString(accommodation) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof СruiseShip)) return false;
        if (!super.equals(o)) return false;
        СruiseShip that = (СruiseShip) o;
        return passengerAmount == that.passengerAmount &&
                cabinsAmount == that.cabinsAmount &&
                Arrays.equals(accommodation, that.accommodation);
    }
}
class TugBoat extends Ship{
    int tractionMax;
    int power;
    Beam beam;

    public TugBoat(Window[] windows, String color, String fuelType, String producer, Engine engine, int maxSpeed, int commandAmount, Anchor anchor, int tonnage, Boat[] boats, int tractionMax, int power, Beam beam) {
        super(windows, color, fuelType, producer, engine, maxSpeed, commandAmount, anchor, tonnage, boats);
        this.tractionMax = tractionMax;
        this.power = power;
        this.beam = beam;
    }

    @Override
    public String toString() {
        return "TugBoat{" +
                "windows = " + Arrays.toString(windows) +
                ", color = " + color +
                ", fuelType = " + fuelType +
                ", producer = " + producer +
                ", engine = " + engine +
                ", maxSpeed = " + maxSpeed +
                ", commandAmount = " + commandAmount +
                ", anchor = " + anchor +
                ", tonnage = " + tonnage +
                ", boats = " + Arrays.toString(boats) +
                ", tractionMax = " + tractionMax +
                ", power = " + power +
                ", beam = " + beam +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TugBoat)) return false;
        if (!super.equals(o)) return false;
        TugBoat tugBoat = (TugBoat) o;
        return tractionMax == tugBoat.tractionMax &&
                power == tugBoat.power &&
                beam.equals(tugBoat.beam);
    }
}
class Tanker extends Ship{
    int  cargoTanksAmount;
    int settlingTanksAmount;
    OilPump oilPump;

    public Tanker(Window[] windows, String color, String fuelType, String producer, Engine engine, int maxSpeed, int commandAmount, Anchor anchor, int tonnage, Boat[] boats, int cargoTanksAmount, int settlingTanksAmount, OilPump oilPump) {
        super(windows, color, fuelType, producer, engine, maxSpeed, commandAmount, anchor, tonnage, boats);
        this.cargoTanksAmount = cargoTanksAmount;
        this.settlingTanksAmount = settlingTanksAmount;
        this.oilPump = oilPump;
    }

    @Override
    public String toString() {
        return "Tanker{" +
                "windows = " + Arrays.toString(windows) +
                ", color = " + color +
                ", fuelType = " + fuelType +
                ", producer = " + producer +
                ", engine = " + engine +
                ", maxSpeed = " + maxSpeed +
                ", commandAmount = " + commandAmount +
                ", anchor = " + anchor +
                ", tonnage = " + tonnage +
                ", boats = " + Arrays.toString(boats) +
                ", cargoTanksAmount = " + cargoTanksAmount +
                ", settlingTanksAmount = " + settlingTanksAmount +
                ", oilPump = " + oilPump +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tanker)) return false;
        if (!super.equals(o)) return false;
        Tanker tanker = (Tanker) o;
        return cargoTanksAmount == tanker.cargoTanksAmount &&
                settlingTanksAmount == tanker.settlingTanksAmount &&
                oilPump.equals(tanker.oilPump);
    }

}

class Boat{} class Anchor{} class Mirror{} class Engine{}
class Window{} class Wing{} class Chassis{} class Beam{} class Accommodation{} class OilPump{}


