package skypro.course3.lesson32employeebook.exception;

public class InvalidEmployeeRequestException extends RuntimeException {

    public InvalidEmployeeRequestException() {
    }

    public InvalidEmployeeRequestException(String message) {
        super(message);
    }
}