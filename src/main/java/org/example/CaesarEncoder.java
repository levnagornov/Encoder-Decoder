package org.example;

import java.util.HashMap;
import java.util.Map;

public class CaesarEncoder {
    private final Map<Character, Integer> alphabetWithPositions;
    private final String alphabet;

    public CaesarEncoder(String alphabet) throws EmptyAlphabetException, InvalidCharacterInAlphabetException, NotUniqueLettersInAlphabetException {
        if (alphabet.length() == 0) {
            throw new EmptyAlphabetException();
        }

        this.alphabet = alphabet;
        this.alphabetWithPositions = createAlphabetWithPositions();
    }

    /**
     * Encodes a text with a Caesar cipher. The Caesar cipher is a simple method of encoding messages.
     * It uses a substitution method where letters in the alphabet are shifted
     * by some fixed number of spaces to yield an encoding alphabet.
     * A Caesar cipher with a shift of 1 would encode an A as a B, an M as an N, and a Z as an A, and so on.
     *
     * @param text text to be encoded.
     * @param key  the number by which a letter in the alphabet is shifted.
     * @return the string of the encoded text by the given key.
     * @throws LetterIsNotInAlphabetException if any of letter of the text is not in the alphabet.
     */
    public String encode(String text, int key) throws LetterIsNotInAlphabetException {
        if (key == 0 || key % alphabet.length() == 0) {
            return text;
        }

        var encodedText = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char currentLetter = text.charAt(i);
            if (!Character.isAlphabetic(currentLetter)) {
                encodedText.append(currentLetter);
                continue;
            }

            Integer alphabeticLetterPosition = alphabetWithPositions.get(currentLetter);
            if (alphabeticLetterPosition == null) {
                throw new LetterIsNotInAlphabetException(Character.toString(currentLetter));
            }

            int newLetterIndex = alphabeticLetterPosition + key;
            if (newLetterIndex > alphabet.length()) {
                newLetterIndex = newLetterIndex % alphabet.length();
            }

            char newLetter = alphabet.charAt(newLetterIndex - 1);
            char newLetterWithOriginalCase = Character.isUpperCase(currentLetter)
                    ? Character.toUpperCase(newLetter)
                    : Character.toLowerCase(newLetter);

            encodedText.append(newLetterWithOriginalCase);
        }

        return encodedText.toString();
    }

    /**
     * It creates a map of a letter and alphabet letter position.
     * Example: if alphabet = "ABC", then alphabet with positions will be {A : 1, B : 2, C : 3}
     *
     * @return A map of a letter and alphabet letter position.
     * @throws InvalidCharacterInAlphabetException if alphabet contains non-alphabetic character.
     * @throws NotUniqueLettersInAlphabetException if alphabet contains duplicates of one letter.
     */
    private Map<Character, Integer> createAlphabetWithPositions() throws InvalidCharacterInAlphabetException, NotUniqueLettersInAlphabetException {
        Map<Character, Integer> alphabetWithPositions = new HashMap<>();
        for (int i = 0; i < alphabet.length(); i++) {
            var currentLetter = alphabet.charAt(i);
            if (!Character.isAlphabetic(currentLetter)) {
                throw new InvalidCharacterInAlphabetException(Character.toString(currentLetter));
            }

            if (alphabetWithPositions.get(currentLetter) != null) {
                throw new NotUniqueLettersInAlphabetException(Character.toString(currentLetter));
            }

            alphabetWithPositions.put(Character.toLowerCase(currentLetter), i + 1);
            alphabetWithPositions.put(Character.toUpperCase(currentLetter), i + 1);
        }

        return alphabetWithPositions;
    }
}
