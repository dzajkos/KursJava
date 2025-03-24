public class Main {
    public static void main(String[] args) {

        Car car1 = new Car("Honda", 0, fuelType.PETROL, "Civic", 2000, 4);

        Motorcycle motorcycle1 = new Motorcycle("Yamaha", 0, fuelType.PETROL, "Szybki", 20050);

        car1.refuel(9.5);

        car1.drive();

        car1.displayInfo();
    }
}
