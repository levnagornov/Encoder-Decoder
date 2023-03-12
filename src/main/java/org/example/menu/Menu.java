package org.example.menu;

import java.util.Scanner;

public interface Menu {
    boolean run();

    default int getIntChoice() {
        printInputTip();
        Scanner console = new Scanner(System.in);
        if (!console.hasNextInt()) {
            return -1;
        }

        return console.nextInt();
    }

    default void printInputTip() {
        System.out.println("Choose option by typing its number in and pressing ENTER.");
        System.out.print(">>> ");
    }

    default void printInvalidOptionTip() {
        System.out.println("Invalid option. Please type number and press ENTER to confirm the option");
    }

    default <T extends Enum<T> & TextDescription> void printOptions(Class<T> clazz) {
        System.out.println("Select an option:");
        var options = clazz.getEnumConstants();
        for (int i = 0; i < options.length; i++) {
            var optionPosition = i + 1;
            var optionName = options[i].getText();
            System.out.println("[" + optionPosition + "] --- " + optionName);
        }
    }

    void printHeader();
}
