public abstract class Vehicle {
    protected String brand;
    protected String model;
    protected int year;
    protected fuelType fuelType;
    protected double fuel;

    public void displayInfo() {
        System.out.println(brand);
        System.out.println(model);
        System.out.println(year);
        System.out.println(fuelType);
        System.out.println(fuel);
    }

    public void refuel(double liters) {
        fuel = fuel + liters;
        System.out.println("Zatankowano " + liters + "l paliwa, cena wynosi " + liters * fuelType.getPrice() + "zł");
    }

    public Vehicle(String brand, double fuel, fuelType fuelType, String model, int year) {
        this.brand = brand;
        this.fuel = fuel;
        this.fuelType = fuelType;
        this.model = model;
        this.year = year;
    }
}
