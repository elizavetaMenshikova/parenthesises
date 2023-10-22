package org.example.enums;

public enum ParenthesisEnum {
    OPENED_BRACE('{'),
    OPENED_ROUND_PARENTHESIS('('),
    OPENED_SQUARE_BRACKET('['),
    CLOSED_BRACE('}'),
    CLOSED_ROUND_PARENTHESIS(')'),
    CLOSED_SQUARE_BRACKET(']');

    private final char value;

    ParenthesisEnum(char value) {
        this.value = value;
    }

    public char getValue() {
        return value;
    }
}
