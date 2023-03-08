package org.example;

public class Main {
    public static void main(String[] args) {
        var alphabet = "AAAB";
        CaesarEncoder caesarEncoder;

        try {
            caesarEncoder = new CaesarEncoder(alphabet);
        } catch (InvalidCharacterInAlphabetException | EmptyAlphabetException | NotUniqueLettersInAlphabetException e) {
            System.out.println(e.getMessage());
            return;
        }

        try {
            System.out.println("ABAB");
            System.out.println(caesarEncoder.encode("ABAB", 53));
        } catch (LetterIsNotInAlphabetException e) {
            System.out.println("There is bad letter. Please use English letters only.");
        }
    }
}