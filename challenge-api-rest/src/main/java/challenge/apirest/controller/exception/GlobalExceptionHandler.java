package challenge.apirest.controller.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.fasterxml.jackson.core.JsonProcessingException;

import challenge.apirest.service.exception.BusinessException;
import challenge.apirest.service.exception.NotImplementedException;

import java.lang.IllegalArgumentException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handle(IllegalArgumentException exception) {
        return new ResponseEntity<>("um argumento informado não é válido", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(JsonProcessingException.class)
    public ResponseEntity<String> handle(JsonProcessingException exception) {
        return new ResponseEntity<>("houve um erro ao tratar dados json", HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(NotImplementedException.class)
    public ResponseEntity<String> handle(NotImplementedException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<String> handle(BusinessException exception) {
        return new ResponseEntity<>("houve um erro nas regras de negócio do sistema", HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<String> handle(Throwable exception) {
        logger.error("erro inesperado", exception);
        return new ResponseEntity<>("erro inesperado", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
