package org.example;

import org.example.alphabet.Alphabet;
import org.example.alphabet.AlphabetDictionary;
import org.example.encoder.CaesarEncoder;
import org.example.exception.EmptyAlphabetException;
import org.example.exception.InvalidCharacterInAlphabetException;
import org.example.exception.LetterIsNotInAlphabetException;
import org.example.exception.NotUniqueLettersInAlphabetException;
import org.example.menu.MainMenu;
import org.example.menu.MenuManager;

public class Main {
    public static void main(String[] args) {
        runApp();
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
            var hello = "Hello world";
            System.out.println(hello);
            System.out.println(caesarEncoder.encode(hello, 53));
        } catch (LetterIsNotInAlphabetException e) {
            System.out.println("There is a bad letter. Please use English letters only.");
        }
    }

    public static void runApp() {
        printGreeting();
        var isAppRunning = true;
        while (isAppRunning) {
            isAppRunning = MenuManager.getMenu(MainMenu.class).run();
        }
    }

    public static void printGreeting() {
        System.out.println("*******************************");
        System.out.println("*    My EncoderDecoder app    *");
        System.out.println("*******************************");
    }
}