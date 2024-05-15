package br.com.fiap.trafego.advice;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class ApplicationExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleInvalidArgument(MethodArgumentNotValidException error) {

        Map<String, String> errorMap = new HashMap<>();
        List<FieldError> campos = error.getBindingResult().getFieldErrors();

        for(FieldError campo : campos) {
            errorMap.put(campo.getField(), campo.getDefaultMessage());
        }

        return errorMap;

    }

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(DataIntegrityViolationException.class)
    public Map<String, String> handleIntegrityViolation() {
        Map<String, String> mapaErro = new HashMap<>();
        mapaErro.put("erro", "ORA-02291: Restrição de Integridade: Informação duplicada ou que não consta no banco de dados");
        return mapaErro;
    }

}