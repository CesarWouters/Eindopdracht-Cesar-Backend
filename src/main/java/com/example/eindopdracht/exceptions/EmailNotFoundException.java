package com.example.eindopdracht.exceptions;

public class EmailNotFoundException extends RuntimeException {
    public EmailNotFoundException() {
        super("Geen gebruiker gevonden met dit emailadres.");
    }

    public EmailNotFoundException(String message) {
        super(message);
    }

}
