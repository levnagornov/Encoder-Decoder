package org.example.menu;

public enum EncodeMenuOption implements TextDescription {
    CaesarEncode ("Caesar encoder"),
    BackToMainMenu ("Back to Main menu");

    private final String optionText;
    EncodeMenuOption(String optionText) {
        this.optionText = optionText;
    }

    public String getText() {
        return this.optionText;
    }
}
