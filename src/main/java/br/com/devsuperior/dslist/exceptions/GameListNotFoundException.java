package br.com.devsuperior.dslist.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class GameListNotFoundException extends RuntimeException {
    public GameListNotFoundException(String message) {
        super(message);
    }
}
