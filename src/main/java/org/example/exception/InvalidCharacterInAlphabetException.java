package org.example.exception;

public class InvalidCharacterInAlphabetException extends Exception {
    public InvalidCharacterInAlphabetException(String message) {
        super("Alphabet contains invalid character " + message + ". It must be only an alphabetic letter.");
    }
}
