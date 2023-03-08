package org.example;

public class EmptyAlphabetException extends Exception {
    public EmptyAlphabetException() {
        super("Alphabet can't be empty.");
    }
}
