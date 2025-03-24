public record Person (String firstName, String lastName, String number) {
    @Override
    public String toString() {
        return firstName + " " + lastName + " " + number;
    }
}
