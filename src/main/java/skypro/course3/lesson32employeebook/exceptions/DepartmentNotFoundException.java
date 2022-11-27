package skypro.course3.lesson32employeebook.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Указанный отдел не найден")
public class DepartmentNotFoundException extends RuntimeException {

    public DepartmentNotFoundException() {
    }
}
