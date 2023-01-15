package lt.seb.api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(ProductNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionResponse handlingProductNotFound(ProductNotFoundException exception) {
        return new ExceptionResponse(String.format("Product %s not found", exception.getProductId()), HttpStatus.NOT_FOUND);
    }

}
