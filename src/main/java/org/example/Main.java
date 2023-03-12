package org.example;

import org.example.alphabet.Alphabet;
import org.example.alphabet.AlphabetDictionary;
import org.example.encoder.CaesarEncoder;
import org.example.exception.EmptyAlphabetException;
import org.example.exception.InvalidCharacterInAlphabetException;
import org.example.exception.LetterIsNotInAlphabetException;
import org.example.exception.NotUniqueLettersInAlphabetException;
import org.example.menu.ConsoleMenu;

public class Main {
    public static void main(String[] args) {
        var isAppRunning = true;
        while (isAppRunning) {
            isAppRunning = ConsoleMenu.runMainMenu();
        }
    }

    public static void tryCaesarEncode() {
        AlphabetDictionary englishAlphabet;

        try {
            englishAlphabet = new Alphabet("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        } catch (InvalidCharacterInAlphabetException | EmptyAlphabetException | NotUniqueLettersInAlphabetException e) {
            System.out.println(e.getMessage());
            return;
        }

        CaesarEncoder caesarEncoder = new CaesarEncoder(englishAlphabet);

        try {
            System.out.println("ABAB");
            System.out.println(caesarEncoder.encode("ABAB", 53));
        } catch (LetterIsNotInAlphabetException e) {
            System.out.println("There is a bad letter. Please use English letters only.");
        }
    }
}