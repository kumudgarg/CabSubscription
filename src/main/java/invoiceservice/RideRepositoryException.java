package invoiceservice;

public class RideRepositoryException extends Exception {
    public RideRepositoryException(String message, String name) {
        super(message);
        this.type = ExceptionType.valueOf(name);
    }

    public enum ExceptionType {
        NULL_VALUE
    }

    public ExceptionType type;

    public RideRepositoryException(String message, ExceptionType type) {
        super(message);
        this.type = type;
    }

    public RideRepositoryException(String message, ExceptionType type, Throwable cause) {
        super(message, cause);
        this.type = type;
    }
}
