package org.example.enums;

import java.util.Arrays;

import static org.example.enums.ParenthesisEnum.*;

public enum ClosedFiguresEnum {

    BRACE(CLOSED_BRACE),
    ROUND_PARENTHESIS(CLOSED_ROUND_PARENTHESIS),
    SQUARE_BRACKET(CLOSED_SQUARE_BRACKET);

    private final ParenthesisEnum closedFigure;

    ClosedFiguresEnum(ParenthesisEnum openedFigure) {
        this.closedFigure = openedFigure;
    }

    public ParenthesisEnum getClosedFigure() {
        return closedFigure;
    }

    public static boolean isClosed(char figure) {
        return Arrays.stream(ClosedFiguresEnum.values())
                .anyMatch(parenthesis -> parenthesis.getClosedFigure().getValue() == figure);
    }
}
