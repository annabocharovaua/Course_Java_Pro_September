public class Car {
    private final String brand;
    private String model;
    private int year;

    public Car(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
    }

    public void start() {
        startElectricity();
        startCommand();
        startFuelSystem();
    }

    private void startElectricity() {
        System.out.println("Starting electricity system");
    }

    private void startCommand() {
        System.out.println("Starting command module");
    }

    private void startFuelSystem() {
        System.out.println("Starting fuel system");
    }
}