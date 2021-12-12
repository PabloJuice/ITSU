package Main;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Car car1 = new Car("BMW");
        Car car2 = new Car("Opel");
        Car car3 = new Car("Nissan");
        car1 = null;
        car2 = null;
        car3 = null;
        System.gc();
        System.out.println(Car.modelList);
    }
}

class Car{
    static List<String> modelList = new ArrayList<>();
    private String model;

    public Car(String model){
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public void finalize() {
        modelList.add(this.getModel());
    }
}