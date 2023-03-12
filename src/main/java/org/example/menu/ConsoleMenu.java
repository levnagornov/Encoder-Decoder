package org.example.menu;

import java.util.Scanner;

public class ConsoleMenu {
    public static void println(String text) {
        System.out.println(text);
    }

    public static void print(String text) {
        System.out.print(text);
    }

    public static void printGreeting() {
        ConsoleMenu.println("*******************************");
        ConsoleMenu.println("*    My EncoderDecoder app    *");
        ConsoleMenu.println("*******************************");
        ConsoleMenu.println("");
    }

    private static void printMainMenu() {
        ConsoleMenu.println("< Main menu >");
        ConsoleMenu.println("Select an option:");
        ConsoleMenu.printOptions(MainMenuOption.class);
    }

    private static void printEncodeMenu() {
        ConsoleMenu.println("< Encode menu >");
        ConsoleMenu.println("Select an option:");
        ConsoleMenu.printOptions(EncodeMenuOption.class);
    }

    private static void printDecodeMenu() {
        ConsoleMenu.println("< Decode menu >");
        ConsoleMenu.println("Select an option:");
        ConsoleMenu.printOptions(DecodeMenuOption.class);
    }

    private static void printCaesarEncodeMenu() {
        ConsoleMenu.println("< Caesar encoder menu >");
        ConsoleMenu.println("Select an option:");
        ConsoleMenu.printOptions(CaesarEncoderMenuOption.class);
    }

    private static void printCaesarDecodeMenu() {
        ConsoleMenu.println("< Caesar decoder menu >");
        ConsoleMenu.println("Select an option:");
        ConsoleMenu.printOptions(CaesarDecoderMenuOption.class);
    }

    private static void printExitMessage() {
        ConsoleMenu.println("Thank you for using our app! Goodbye.");
    }

    private static int getUserMenuOptionChoice() {
        ConsoleMenu.println("Choose option by typing its number in and pressing ENTER.");
        ConsoleMenu.print(">>> ");
        Scanner console = new Scanner(System.in);
        if (!console.hasNextInt()) {
            return -1;
        }

        ConsoleMenu.println("");
        return console.nextInt();
    }

    private static <T extends Enum<T> & TextDescription> void printOptions(Class<T> clazz) {
        var options = clazz.getEnumConstants();
        for (int i = 0; i < options.length; i++) {
            var optionPosition = i + 1;
            var optionName = options[i].getText();
            ConsoleMenu.println("[" + optionPosition + "] --- " + optionName);
        }
    }

    private static void printInvalidOptionTip() {
        ConsoleMenu.println("Invalid option. Please type number and press ENTER to confirm the option");
    }

    private static boolean runExit() {
        ConsoleMenu.printExitMessage();
        return false;
    }

    public static boolean runMainMenu() {
        ConsoleMenu.printMainMenu();
        var usersChoice = ConsoleMenu.getUserMenuOptionChoice();
        switch (usersChoice) {
            case 1 -> {
                return runEncodeMenu();
            }
            case 2 -> {
                return runDecodeMenu();
            }
            case 3 -> {
                return runExit();
            }
            default -> {
                printInvalidOptionTip();
                return runMainMenu();
            }
        }
    }

    private static boolean runEncodeMenu() {
        ConsoleMenu.printEncodeMenu();
        var usersChoice = ConsoleMenu.getUserMenuOptionChoice();
        switch (usersChoice) {
            case 1 -> {
                return runCaesarEncoderMenu();
            }
            case 2 -> {
                return runMainMenu();
            }
            default -> {
                printInvalidOptionTip();
                return runEncodeMenu();
            }
        }
    }

    private static boolean runDecodeMenu() {
        ConsoleMenu.printDecodeMenu();
        var usersChoice = ConsoleMenu.getUserMenuOptionChoice();
        switch (usersChoice) {
            case 1 -> {
                return runCaesarDecoderMenu();
            }
            case 2 -> {
                return runMainMenu();
            }
            default -> {
                printInvalidOptionTip();
                return runDecodeMenu();
            }
        }
    }

    private static boolean runCaesarEncoderMenu() {
        ConsoleMenu.printCaesarEncodeMenu();
        var usersChoice = ConsoleMenu.getUserMenuOptionChoice();
        switch (usersChoice) {
            case 1 -> {
                // TODO: Caesar Encoder - encode user string in the console
                ConsoleMenu.println("EncodeString - done");
                return false;
            }
            case 2 -> {
                // TODO: Caesar Encoder - encode user txt file
                ConsoleMenu.println("EncodeTextFile - done");
                return false;
            }
            case 3 -> {
                return runEncodeMenu();
            }
            default -> {
                printInvalidOptionTip();
                return runCaesarEncoderMenu();
            }
        }
    }

    private static boolean runCaesarDecoderMenu() {
        ConsoleMenu.printCaesarDecodeMenu();
        var usersChoice = ConsoleMenu.getUserMenuOptionChoice();
        switch (usersChoice) {
            case 1 -> {
                // TODO: Caesar Decoder - decode user string in the console
                ConsoleMenu.println("DecodeString - done");
                return false;
            }
            case 2 -> {
                // TODO: Caesar Decoder - decode user txt file
                ConsoleMenu.println("DecodeTextFile - done");
                return false;
            }
            case 3 -> {
                return runDecodeMenu();
            }
            default -> {
                printInvalidOptionTip();
                return runCaesarEncoderMenu();
            }
        }
    }
}
