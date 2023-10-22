package org.example.enums;

import java.util.Arrays;

import static org.example.enums.ParenthesisEnum.*;

public enum OpenedFiguresEnum {

    BRACE(OPENED_BRACE),
    ROUND_PARENTHESIS(OPENED_ROUND_PARENTHESIS),
    SQUARE_BRACKET(OPENED_SQUARE_BRACKET);

    private final ParenthesisEnum openedFigure;

    OpenedFiguresEnum(ParenthesisEnum openedFigure) {
        this.openedFigure = openedFigure;
    }

    public ParenthesisEnum getOpenedFigure() {
        return openedFigure;
    }

    public static boolean isOpened(char figure) {
        return Arrays.stream(OpenedFiguresEnum.values())
                .anyMatch(parenthesis -> parenthesis.getOpenedFigure().getValue() == figure);
    }
}
