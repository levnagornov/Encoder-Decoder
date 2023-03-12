package org.example.menu;

public class CaesarDecoderMenu implements Menu {
    @SuppressWarnings("unused")
    public enum Options implements TextDescription {
        DecodeString("Decode a string"),
        DecodeTextFile("Decode a text file"),
        BackToDecodeMenu("Back to decode menu");

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
        printOptions(CaesarEncoderMenu.Options.class);
        var usersChoice = getIntChoice();
        switch (usersChoice) {
            case 1 -> {
                // TODO: Caesar Decoder - decode user string in the console
                System.out.println("Decode a string - done");
                return new MainMenu().run();
            }
            case 2 -> {
                // TODO: Caesar Decoder - decode user txt file
                System.out.println("Decode a text file - done");
                return new MainMenu().run();
            }
            case 3 -> {
                return new DecodeMenu().run();
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
        System.out.println("< Caesar decoder menu >");
    }
}
