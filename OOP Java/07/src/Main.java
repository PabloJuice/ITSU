import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<Vehicle> vehicles = new ArrayList();
        vehicles.add(new Vehicle("diesel", 1000, 220, 1500));
        vehicles.add(new Vehicle("gas", 2000, 200, 1400));
        vehicles.add(new Vehicle("biofuel", 7000, 120, 2000));
        vehicles.add(new Vehicle("electricity", 5000, 300, 1200));
        System.out.println(vehicles);
        String scanned = new Scanner(System.in).nextLine();
        switch (scanned){
            case "fuel":
                Collections.sort(vehicles, new ComparatorByFuelType());
                break;
            default:
                break;
        }
        System.out.println(vehicles);
    }
}
class Vehicle{
    String fuelType;
    int price;
    int maxSpeed, weight;

    public Vehicle(String fuelType, int price, int maxSpeed, int weight) {
        this.fuelType = fuelType;
        this.price = price;
        this.maxSpeed = maxSpeed;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Vehicle{ " +
                "fuelType = '" + fuelType + '\'' +
                ", price = " + price +
                ", maxSpeed = " + maxSpeed + " km/hr " +
                ", weight = " + weight + " kg " +
                '}';
    }
}
class ComparatorByFuelType implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        return ((Vehicle)o1).fuelType.compareTo(((Vehicle)o2).fuelType) ;
    }
}
class ComparatorByPrice implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        return ((Vehicle)o2).price -  ((Vehicle)o1).price;
    }
}
class ComparatorByMaxSpeed implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        return ((Vehicle)o2).price -  ((Vehicle)o1).price;
    }
}
class ComparatorByWeight implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {

        return ((Vehicle)o2).price -  ((Vehicle)o1).price;
    }
}
