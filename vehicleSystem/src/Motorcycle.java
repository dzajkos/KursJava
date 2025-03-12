public class Motorcycle extends Vehicle implements Drivable{

    @Override
    public void drive() {
        System.out.println("Motocykl jedzie");
    }

    public Motorcycle(String brand, double fuel, fuelType fuelType, String model, int year) {
        super(brand, fuel, fuelType, model, year);
    }
}
