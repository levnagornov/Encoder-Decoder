package org.example.exception;

public class LetterIsNotInAlphabetException extends Exception {
    public LetterIsNotInAlphabetException(String message) {
        super("Letter <" + message + "> is not in the alphabet.");
    }
}
