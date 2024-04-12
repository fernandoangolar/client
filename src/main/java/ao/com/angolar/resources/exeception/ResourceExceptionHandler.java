package ao.com.angolar.resources.exeception;

import ao.com.angolar.services.excrption.ResourceEntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ResourceEntityNotFoundException.class)
    public ResponseEntity<StardarError> entityNotFound(ResourceEntityNotFoundException ex, HttpServletRequest request ) {

        HttpStatus status = HttpStatus.NOT_FOUND;

        StardarError error = new StardarError();
        error.setTimestamp(Instant.now());
        error.setStatus(status.value());
        error.setError("Entity not found");
        error.setMessage(ex.getMessage());
        error.setPath(request.getRequestURI());

        return ResponseEntity.status(status)
                .body(error);
    }
}
