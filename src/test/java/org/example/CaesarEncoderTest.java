package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CaesarEncoderTest {

    private CaesarEncoder caesarEncoder;

    @BeforeEach
    void setUp() throws EmptyAlphabetException, InvalidCharacterInAlphabetException, NotUniqueLettersInAlphabetException {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        caesarEncoder = new CaesarEncoder(alphabet);
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

    @Test
    void constructorThrowsEmptyAlphabetException() {
        var emptyAlphabet = "";
        assertThrows(EmptyAlphabetException.class, () -> new CaesarEncoder(emptyAlphabet));
    }

    @Test
    void constructorThrowsInvalidCharacterInAlphabetExceptionOnNumberInAlphabet() {
        var invalidAlphabet = "ABC1";
        assertThrows(InvalidCharacterInAlphabetException.class, () -> new CaesarEncoder(invalidAlphabet));
    }

    @Test
    void constructorThrowsInvalidCharacterInAlphabetExceptionOnPunctuationSignInAlphabet() {
        var invalidAlphabet = "ABC.";
        assertThrows(InvalidCharacterInAlphabetException.class, () -> new CaesarEncoder(invalidAlphabet));
    }

    @Test
    void constructorThrowsInvalidCharacterInAlphabetExceptionOnSpaceInAlphabet() {
        var invalidAlphabet = "ABC ";
        assertThrows(InvalidCharacterInAlphabetException.class, () -> new CaesarEncoder(invalidAlphabet));
    }

    @Test
    void constructorThrowsNotUniqueLettersInAlphabetException() {
        var invalidAlphabet = "ABBA";
        assertThrows(NotUniqueLettersInAlphabetException.class, () -> new CaesarEncoder(invalidAlphabet));
    }
}