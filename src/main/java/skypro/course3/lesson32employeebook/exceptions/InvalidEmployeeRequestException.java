package skypro.course3.lesson32employeebook.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Введены некорректные данные сотрудника")
public class InvalidEmployeeRequestException extends RuntimeException {

    public InvalidEmployeeRequestException() {
    }
}