package invoiceservice;

public class RideRepositoryException extends Exception {

    public enum ExceptionType {
        NULL_VALUE, NO_RIDE_FOUND
    }

    public ExceptionType type;

    public RideRepositoryException(String message, ExceptionType type) {
        super(message);
        this.type = type;
    }

}
