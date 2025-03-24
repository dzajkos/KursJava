public enum fuelType {
    PETROL(6.3), DIESEL(6.5), ELECTRIC(1.3);

    final private double price;

    fuelType(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}

