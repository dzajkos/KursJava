import static java.lang.StringTemplate.STR;
public class Car extends Vehicle implements Drivable{

    private int doors;

    @Override
    public void drive() {
        System.out.println("Samochód jedzie");
    }

    @Override
    public void displayInfo () {
        System.out.println("SAMOCHÓD:");
        System.out.println("Model: " + brand + " " + model);
        System.out.println("Rocznik: " + year);
        System.out.println("Paliwo: " + fuelType);
        System.out.println("W baku: " + fuel + "l");


    }

    public Car(String brand, double fuel, fuelType fuelType, String model, int year, int doors) {
        super(brand, fuel, fuelType, model, year);
        this.doors = doors;
    }
}
