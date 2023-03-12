package org.example.menu;

public enum CaesarDecoderMenuOption implements TextDescription {
    DecodeString ("Decode a string"),
    DecodeTextFile ("Decode a text file"),
    BackToDecodeMenu ("Back to decode menu");

    private final String optionText;
    CaesarDecoderMenuOption(String optionText) {
        this.optionText = optionText;
    }

    public String getText() {
        return this.optionText;
    }
}
