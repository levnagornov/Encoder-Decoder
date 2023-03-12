package org.example.menu;

public enum MainMenuOption implements TextDescription {
    Encode ("Encode"),
    Decode ("Decode"),
    Exit ("Exit");

    private final String optionText;
    MainMenuOption(String optionText) {
        this.optionText = optionText;
    }

    public String getText() {
        return this.optionText;
    }
}
