package org.example.menu;

public enum DecodeMenuOption implements TextDescription {
    CaesarDecode ("Caesar Decode"),
    BackToMainMenu ("Back to Main menu");

    private final String optionText;
    DecodeMenuOption(String optionText) {
        this.optionText = optionText;
    }

    public String getText() {
        return this.optionText;
    }
}
