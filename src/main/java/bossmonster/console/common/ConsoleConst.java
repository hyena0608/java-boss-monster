package bossmonster.console.common;

public enum ConsoleConst {

    SPACE(" "),
    ENTER(System.lineSeparator()),
    DOT("."),
    MINUS("-"),
    LEFT_BRACKET("["),
    RIGHT_BRACKET("]"),
    SLASH("/"),
    ONE_LINE_BAR("----------------------------"),
    TWO_LINE_BAR("============================"),
    HP("HP"),
    MP("MP");

    private final String value;

    ConsoleConst(final String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }
}
