package org.example.menu;

import java.util.Map;

public class EncodeMenu implements Menu {
    @SuppressWarnings("unused")
    public enum Options implements TextDescription {
        CaesarEncode("Caesar encoder"),
        BackToMainMenu("Back to Main menu");

        private final String optionText;

        Options(String optionText) {
            this.optionText = optionText;
        }

        public String getText() {
            return this.optionText;
        }
    }

    @Override
    public boolean run() {
        printHeader();
        printOptions(EncodeMenu.Options.class);
        var usersChoice = getIntChoice();
        switch (usersChoice) {
            case 1 -> {
                return MenuManager.getMenu(CaesarEncoderMenu.class).run();
            }
            case 2 -> {
                return MenuManager.getMenu(MainMenu.class).run();
            }
            default -> {
                printInvalidOptionTip();
                return this.run();
            }
        }
    }

    @Override
    public void printHeader() {
        System.out.println();
        System.out.println("< Encode menu >");
    }
}
