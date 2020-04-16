package br.com.tqi.test.development.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EnderecoException extends Exception {

    public EnderecoException(String message) {
        super(message);
    }
}
