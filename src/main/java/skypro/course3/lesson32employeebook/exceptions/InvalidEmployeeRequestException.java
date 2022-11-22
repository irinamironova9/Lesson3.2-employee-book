package skypro.course3.lesson32employeebook.exceptions;

public class InvalidEmployeeRequestException extends RuntimeException {

    public InvalidEmployeeRequestException() {
    }

    public InvalidEmployeeRequestException(String message) {
        super(message);
    }
}