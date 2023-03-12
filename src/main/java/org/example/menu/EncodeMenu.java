package org.example.menu;

public class EncodeMenu implements Menu {
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
                return new CaesarEncoderMenu().run();
            }
            case 2 -> {
                return new MainMenu().run();
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
