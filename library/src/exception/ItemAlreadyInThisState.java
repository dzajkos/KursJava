package exception;

public class ItemAlreadyInThisState extends RuntimeException{

    public ItemAlreadyInThisState(String message) {
        super(message);
    }
}
