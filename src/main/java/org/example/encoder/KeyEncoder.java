package org.example.encoder;

import org.example.exception.LetterIsNotInAlphabetException;

public interface KeyEncoder {
    String encode(String text, int key) throws LetterIsNotInAlphabetException;
}