package org.example.menu;

public class MainMenu implements Menu {
    public enum Options implements TextDescription {
        Encode("Encode"),
        Decode("Decode"),
        Exit("Exit");

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
        printOptions(MainMenu.Options.class);
        var usersChoice = getIntChoice();
        switch (usersChoice) {
            case 1 -> {
                return new EncodeMenu().run();
            }
            case 2 -> {
                return new DecodeMenu().run();
            }
            case 3 -> {
                return exit();
            }
            default -> {
                printInvalidOptionTip();
                return new MainMenu().run();
            }
        }
    }

    private boolean exit() {
        printExitMessage();
        return false;
    }

    private void printExitMessage() {
        System.out.println("Thank you for using our app! Goodbye.");
    }

    @Override
    public void printHeader() {
        System.out.println("");
        System.out.println("< Main menu >");
    }
}
