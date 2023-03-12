package org.example.alphabet;

public interface AlphabetDictionary {
    int getLength();
    Integer getLetterPosition(char letter);
    char getLetterByPosition(int position) throws IndexOutOfBoundsException;
}
