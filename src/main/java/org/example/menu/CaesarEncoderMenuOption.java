package org.example.menu;

public enum CaesarEncoderMenuOption implements TextDescription {
    EncodeString ("Encode a string"),
    EncodeTextFile ("Encode a text file"),
    BackToEncodeMenu ("Back to encode menu");

    private final String optionText;
    CaesarEncoderMenuOption(String optionText) {
        this.optionText = optionText;
    }

    public String getText() {
        return this.optionText;
    }
}
