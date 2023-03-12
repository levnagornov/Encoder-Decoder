package org.example.exception;

public class NotUniqueLettersInAlphabetException extends Exception {
    public NotUniqueLettersInAlphabetException(String message) {
        super("The letter is not unique in the alphabet " + message + ". Alphabet must contain only unique letters");
    }
}
