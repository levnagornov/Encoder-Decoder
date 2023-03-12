package org.example;

import org.example.alphabet.Alphabet;
import org.example.alphabet.AlphabetDictionary;
import org.example.encoder.CaesarEncoder;
import org.example.exception.EmptyAlphabetException;
import org.example.exception.InvalidCharacterInAlphabetException;
import org.example.exception.LetterIsNotInAlphabetException;
import org.example.exception.NotUniqueLettersInAlphabetException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CaesarEncoderTest {

    private CaesarEncoder caesarEncoder;

    @BeforeEach
    void setUp() throws NotUniqueLettersInAlphabetException, EmptyAlphabetException, InvalidCharacterInAlphabetException {
        AlphabetDictionary englishAlphabet = new Alphabet("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        caesarEncoder = new CaesarEncoder(englishAlphabet);
    }

    @Test
    void encodeWithKeyZero() throws LetterIsNotInAlphabetException {
        assertEquals("ABBA", caesarEncoder.encode("ABBA", 0));
    }

    @Test
    void encodeWithSmallPositiveKey() throws LetterIsNotInAlphabetException {
        assertEquals("CDDC", caesarEncoder.encode("ABBA", 2));
    }

    @Test
    void encodeWithSmallNegativeKey() throws LetterIsNotInAlphabetException {
        assertEquals("BCD", caesarEncoder.encode("DEF", -2));
    }

    @Test
    void encodeWithBigPositiveKey() throws LetterIsNotInAlphabetException {
        assertEquals("ABBA", caesarEncoder.encode("ABBA", 26));
    }

    @Test
    void encodeWithBigNegativeKey() throws LetterIsNotInAlphabetException {
        assertEquals("ABBA", caesarEncoder.encode("ABBA", -26));
    }

    @Test
    void encodeWithGiantPositiveKey() throws LetterIsNotInAlphabetException {
        assertEquals("ABBA", caesarEncoder.encode("ABBA", 78));
    }

    @Test
    void encodeWithGiantNegativeKey() throws LetterIsNotInAlphabetException {
        assertEquals("ABBA", caesarEncoder.encode("ABBA", -78));
    }

    @Test
    void encodeIsCaseSensitive() throws LetterIsNotInAlphabetException {
        assertEquals("Efg", caesarEncoder.encode("Def", 1));
    }

    @Test
    void encodeSkipsNonLetters() throws LetterIsNotInAlphabetException {
        assertEquals("?EFG .! OP1", caesarEncoder.encode("?DEF .! NO1", 1));
    }

    @Test
    void encodeThrowsLetterIsNotInAlphabetException() {
        assertThrows(LetterIsNotInAlphabetException.class, () -> caesarEncoder.encode("ABCЯ", 1));
    }
}