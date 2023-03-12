package org.example.encoder;

import org.example.alphabet.AlphabetDictionary;
import org.example.exception.LetterIsNotInAlphabetException;

public class CaesarEncoder implements KeyEncoder {
    private final AlphabetDictionary alphabetDictionary;

    public CaesarEncoder(AlphabetDictionary alphabetDictionary) {
        this.alphabetDictionary = alphabetDictionary;
    }

    /**
     * Encodes a text with a Caesar cipher. The Caesar cipher is a simple method of encoding messages.
     * It uses a substitution method where letters in the alphabetDictionary are shifted
     * by some fixed number of spaces to yield an encoding alphabetDictionary.
     * A Caesar cipher with a shift of 1 would encode an A as a B, an M as an N, and a Z as an A, and so on.
     *
     * @param text text to be encoded.
     * @param key  the number by which a letter in the alphabetDictionary is shifted.
     * @return the string of the encoded text by the given key.
     * @throws LetterIsNotInAlphabetException if any of letter of the text is not in the alphabetDictionary.
     */
    public String encode(String text, int key) throws LetterIsNotInAlphabetException {
        var alphabetLength = alphabetDictionary.getLength();
        if (key == 0 || key % alphabetLength == 0) {
            return text;
        }

        var encodedText = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char currentLetter = text.charAt(i);
            if (!Character.isAlphabetic(currentLetter)) {
                encodedText.append(currentLetter);
                continue;
            }

            Integer alphabeticLetterPosition = alphabetDictionary.getLetterPosition(currentLetter);
            if (alphabeticLetterPosition == null) {
                throw new LetterIsNotInAlphabetException(Character.toString(currentLetter));
            }

            int newLetterIndex = alphabeticLetterPosition + key;
            if (newLetterIndex > alphabetLength) {
                newLetterIndex = newLetterIndex % alphabetLength;
            }

            char newLetter = alphabetDictionary.getLetterByPosition(newLetterIndex - 1);
            char newLetterWithOriginalCase = Character.isUpperCase(currentLetter)
                    ? Character.toUpperCase(newLetter)
                    : Character.toLowerCase(newLetter);

            encodedText.append(newLetterWithOriginalCase);
        }

        return encodedText.toString();
    }
}
